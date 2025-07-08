package com.anbu.plugins

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respond

fun Application.configureStatusPages() {
    install(StatusPages) {

        status(HttpStatusCode.NotFound) {
            call.respond(
                message = "page not found ya jing!",
                status = HttpStatusCode.NotFound
            )
        }

        // Implement Exception
//        exception<AuthenticationException> {
//            call, cause -> call.respond(
//                message = "We caught an exception!",
//                status = HttpStatusCode.OK
//            )
//        }
    }
}