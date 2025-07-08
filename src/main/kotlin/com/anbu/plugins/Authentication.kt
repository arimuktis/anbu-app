package com.anbu.plugins

import com.anbu.domain.models.Endpoint
import com.anbu.domain.models.UserSession
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.auth.Authentication
import io.ktor.server.auth.session
import io.ktor.server.response.respondRedirect

fun Application.configureAuth() {
    install(Authentication) {
        session<UserSession>(name = "auth-session") {
            validate { session ->
                session
            }
            challenge {
                call.respondRedirect(Endpoint.Unauthorized.path)
            }
        }
    }
}