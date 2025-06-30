package com.anbu.routes

import com.anbu.models.ApiResponse
import com.anbu.repository.AnimeRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.application
import io.ktor.server.routing.get
import org.koin.ktor.ext.inject
import kotlin.text.toInt

fun Route.getAllAnimes() {
    val animeRepository: AnimeRepository by application.inject()

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
                message = ApiResponse(success = false, message = "Only Numbers can have at least one number"),
                status = HttpStatusCode.BadRequest
            )
        } catch (e: IllegalArgumentException) {
            call.respond(
                message = ApiResponse(success = false, message = "Animes not Found."),
                status = HttpStatusCode.BadRequest
            )
        }
    }
}