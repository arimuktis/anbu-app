package com.anbu.routes

import com.anbu.repository.HeroRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.searchHeroes() {
    val heroRepository: HeroRepository by application.inject()

    get("/anbu/heroes/search") {
        val name = call.request.queryParameters["name"]
        val apiResponse = heroRepository.searchHero(name = name)

        call.respond(
            message = apiResponse,
            status = HttpStatusCode.OK
        )
    }
}