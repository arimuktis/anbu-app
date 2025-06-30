package com.anbu.routes

import com.anbu.repository.AnimeRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.searchAnimes() {
    val animeRepository: AnimeRepository by application.inject()

    get("/anbu/animes/search") {
        val name = call.request.queryParameters["name"]
        val apiResponse = animeRepository.searchAnime(name = name)

        call.respond(
            message = apiResponse,
            status = HttpStatusCode.OK
        )
    }
}