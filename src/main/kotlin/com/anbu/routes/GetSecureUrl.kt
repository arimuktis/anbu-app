package com.anbu.routes

import com.anbu.domain.models.ApiResponse
import com.anbu.domain.models.Endpoint
import com.anbu.domain.models.UserSession
import io.github.cdimascio.dotenv.dotenv
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.net.URLEncoder
import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

fun Route.getSecureUrl(
    app: Application
) {
    authenticate("auth-session") {

        val dotenv = dotenv {
            ignoreIfMalformed = true
            ignoreIfMissing = true
        }
        val tokenKey = dotenv["BUNNY_SECURE_TOKEN"] ?: error("Missing BUNNY_SECURE_TOKEN")
        val baseUrl  = dotenv["BUNNY_BASE_URL"]     ?: error("Missing BUNNY_BASE_URL")

        get(Endpoint.GetSecureUrl.path) {
            val userSession = call.principal<UserSession>()
            if (userSession == null) {
                app.log.info("INVALID SESSION")
                call.respondRedirect(Endpoint.Unauthorized.path)
            } else {
                try {
                    val guid = call.request.queryParameters["id"]
                    if (guid.isNullOrBlank()) {
                        return@get call.respond(
                            HttpStatusCode.BadRequest,
                            ApiResponse<Unit>(success = false, data = null, message = "Missing video id")
                        )
                    }
                    call.respond(
                        message = ApiResponse(
                            success = true,
                            data = generateBunnySecureUrl(
                                baseUrl = baseUrl,
                                videoGuid = guid,
                                tokenKey = tokenKey
                            )
                        ),
                        status = HttpStatusCode.OK
                    )
                } catch (e: Exception) {
                    app.log.info("GETTING SECURE URL ERROR: ${e.message}")
                    call.respondRedirect(Endpoint.Unauthorized.path)
                }
            }
        }
    }
}

fun generateBunnySecureUrl(
    baseUrl: String,
    videoGuid: String,
    tokenKey: String,
    expiresInSeconds: Long = 3600
): String {
    val encodedPath = "/$videoGuid/"
    val expires = (System.currentTimeMillis() / 1000L) + expiresInSeconds

    val stringToSign = "$encodedPath$expires"
    val hmac = Mac.getInstance("HmacSHA256")
    val secretKey = SecretKeySpec(tokenKey.trim().toByteArray(), "HmacSHA256")
    hmac.init(secretKey)
    val hash = hmac.doFinal(stringToSign.toByteArray())
    val token = Base64.getUrlEncoder().withoutPadding().encodeToString(hash)

    val encodedTokenPath = URLEncoder.encode(encodedPath, "UTF-8")
    return "$baseUrl/$videoGuid/playlist.m3u8?" +
            "bcdn_token=$token&" +
            "expires=$expires&" +
            "token_path=$encodedTokenPath"
}