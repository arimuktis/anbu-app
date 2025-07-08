package com.anbu.routes

import com.anbu.domain.models.Endpoint
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.unauthorizedRoute() {
    get(Endpoint.Unauthorized.path) {
        call.respond(
            message = "Not Authorized.",
            status = HttpStatusCode.Unauthorized
        )
    }
}