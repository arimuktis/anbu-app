package com.anbu.plugins

import com.anbu.data.repository.UserDataSource
import com.anbu.routes.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Application.configureAnbuRouting() {
    routing {
        val userDataSource: UserDataSource by inject(UserDataSource::class.java)
        root()
        tokenVerificationRoute(application, userDataSource)
        getUserInfoRoute(application, userDataSource)
        updateUserRoute(application, userDataSource)
        deleteUserRoute(application, userDataSource)
        getSecureUrl(application)
        singOutRoute()
        authorizedRoute()
        unauthorizedRoute()
        getAllAnimesRoute()
        searchAnimes()

        // 🚀 Add this
        passkeyRoutes()

        // static region

        static("/images") {
            resources("images")
        }

        // end region
    }
}

