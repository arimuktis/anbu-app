package com.anbu.routes

import com.anbu.domain.models.Endpoint
import com.anbu.domain.models.UserSession
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import io.ktor.server.sessions.sessions
import io.ktor.server.sessions.set

fun Route.tokenVerificationRoute() {
    post(Endpoint.TokenVerification.path) {
        call.sessions.set(UserSession(id = "123", name = "Jangkung"))
        call.respondRedirect(Endpoint.Authorized.path)
    }
}