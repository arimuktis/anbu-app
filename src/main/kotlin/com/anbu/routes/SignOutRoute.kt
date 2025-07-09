package com.anbu.routes

import com.anbu.domain.models.ApiResponse
import com.anbu.domain.models.Endpoint
import com.anbu.domain.models.UserSession
import io.ktor.http.HttpStatusCode
import io.ktor.server.auth.authenticate
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.sessions.clear
import io.ktor.server.sessions.sessions

fun Route.singOutRoute() {
    authenticate("auth-session") {
        get(Endpoint.SignOut.path) {
            call.sessions.clear<UserSession>()
            call.respond(
                message = ApiResponse(success = true, data = null),
                status = HttpStatusCode.OK
            )
        }
    }
}