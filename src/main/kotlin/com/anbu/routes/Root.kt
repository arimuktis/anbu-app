package com.anbu.routes

import com.anbu.domain.models.Endpoint
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.root() {
    get(Endpoint.Root.path) {
        call.respond(
            message = "Welcome to the Anbu Bot API!",
            status = HttpStatusCode.OK
        )
    }
}