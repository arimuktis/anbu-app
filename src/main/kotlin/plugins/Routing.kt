package com.anbu.plugins

import com.anbu.routes.authorizedRoute
import com.anbu.routes.getAllAnimes
import com.anbu.routes.root
import com.anbu.routes.searchAnimes
import com.anbu.routes.tokenVerificationRoute
import com.anbu.routes.unauthorizedRoute
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        root()
        tokenVerificationRoute()
        authorizedRoute()
        unauthorizedRoute()
        getAllAnimes()
        getAllAnimes()
        searchAnimes()

        // static region

        static("/images") {
            resources("images")
        }

        // end region
    }
}

