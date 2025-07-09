package com.anbu.routes

import com.anbu.domain.models.ApiResponse
import com.anbu.data.repository.AnimeRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.auth.authenticate
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.application
import io.ktor.server.routing.get
import org.koin.ktor.ext.inject
import kotlin.text.toInt

fun Route.getAllAnimesRoute() {
    val animeRepository: AnimeRepository by application.inject()

    authenticate("auth-session") {
        get("/anbu/animes") {
            try {
                val page = call.request.queryParameters["page"]?.toInt() ?: 1
                require(page in 1..5)

                val apiResponse = animeRepository.getAllAnimes(page = page)

                call.respond(
                    message = apiResponse,
                    status = HttpStatusCode.OK
                )
            } catch (e: NumberFormatException) {
                call.respond(
                    message = ApiResponse<Unit>(success = false, message = "Only Numbers can have at least one number"),
                    status = HttpStatusCode.BadRequest
                )
            } catch (e: IllegalArgumentException) {
                call.respond(
                    message = ApiResponse<Unit>(success = false, message = "Animes not Found."),
                    status = HttpStatusCode.BadRequest
                )
            }
        }
    }
}