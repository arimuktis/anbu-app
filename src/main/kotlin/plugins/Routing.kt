package com.anbu.plugins

import com.anbu.routes.getAllAnimes
import com.anbu.routes.getAllHeroes
import com.anbu.routes.root
import com.anbu.routes.searchHeroes
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        root()
        getAllAnimes()
        getAllHeroes()
        searchHeroes()

        // static region

        static("/images") {
            resources("images")
        }

        // end region
    }
}

