package com.anbu.routes

import com.anbu.data.repository.UserDataSource
import com.anbu.domain.models.ApiResponse
import com.anbu.domain.models.TokenVerificationRequest
import com.anbu.domain.models.Endpoint
import com.anbu.domain.models.User
import com.anbu.domain.models.UserSession
import com.anbu.utils.Constants.AUDIENCE
import com.anbu.utils.Constants.ISSUER
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.gson.GsonFactory
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*

fun Route.tokenVerificationRoute(
    app: Application,
    userDataSource: UserDataSource
) {
    post(Endpoint.TokenVerification.path) {
        val request = call.receive<TokenVerificationRequest>()
        if (request.tokenId.isNotEmpty()) {
            val result = verifyGoogleTokenId(tokenId = request.tokenId)
            if (result != null) {
                saveUserToDatabaseJson(
                    app = app,
                    call = call,
                    result = result,
                    userDataSource = userDataSource
                )
            } else {
                app.log.info("TOKEN VERIFICATION FAILED")
                call.respond(
                    HttpStatusCode.Unauthorized,
                    ApiResponse<Unit>(success = false, message = "Token verification failed")
                )
            }
        } else {
            app.log.info("EMPTY TOKEN ID")
            call.respond(
                HttpStatusCode.BadRequest,
                ApiResponse<Unit>(success = false, message = "Token ID is empty")
            )
        }
    }
}

private suspend fun saveUserToDatabaseJson(
    app: Application,
    call: ApplicationCall,
    result: GoogleIdToken,
    userDataSource: UserDataSource
) {
    val sub = result.payload["sub"].toString()
    val name = result.payload["name"].toString()
    val emailAddress = result.payload["email"].toString()
    val profilePhoto = result.payload["picture"].toString()

    val user = User(id = sub, name = name, emailAddress = emailAddress, profilePhoto = profilePhoto)
    val response = userDataSource.saveUserInfo(user)

    if (response) {
        app.log.info("USER SUCCESSFULLY SAVED/RETRIEVED")
        call.sessions.set(UserSession(id = sub, name = name))
        call.respond(
            HttpStatusCode.OK,
            ApiResponse<Unit>(success = true, message = "User authenticated")
        )
    } else {
        app.log.info("ERROR SAVING THE USER")
        call.respond(
            HttpStatusCode.InternalServerError,
            ApiResponse<Unit>(success = false, message = "Failed to save user")
        )
    }
}

fun verifyGoogleTokenId(tokenId: String): GoogleIdToken? {
    try {
        val verifier = GoogleIdTokenVerifier.Builder(NetHttpTransport(), GsonFactory())
            .setAudience(listOf(AUDIENCE))
            .setIssuer(ISSUER)
            .build()
        return verifier.verify(tokenId)
    } catch (e: Exception) {
        return null
    }
}