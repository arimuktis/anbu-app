package com.anbu.plugins

import com.anbu.data.repository.UserDataSource
import com.anbu.routes.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Application.configureRouting() {
    routing {
        val userDataSource: UserDataSource by inject(UserDataSource::class.java)
        root()
        tokenVerificationRoute(application, userDataSource)
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

