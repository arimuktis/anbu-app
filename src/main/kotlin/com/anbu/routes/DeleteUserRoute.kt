package com.anbu.routes

import com.anbu.data.repository.UserDataSource
import com.anbu.domain.models.ApiResponse
import com.anbu.domain.models.Endpoint
import com.anbu.domain.models.UserSession
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.log
import io.ktor.server.auth.authenticate
import io.ktor.server.auth.principal
import io.ktor.server.response.respond
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.Route
import io.ktor.server.routing.RoutingCall
import io.ktor.server.routing.delete
import io.ktor.server.sessions.clear
import io.ktor.server.sessions.sessions

fun Route.deleteUserRoute(
    app: Application,
    userDataSource: UserDataSource
) {
    authenticate("auth-session") {
        delete(Endpoint.DeleteUser.path) {
            val userSession = call.principal<UserSession>()
            if (userSession == null) {
                app.log.info("INVALID SESSION")
                call.respondRedirect(Endpoint.Unauthorized.path)
            } else {
                try {
                    call.sessions.clear<UserSession>()
                    deleteUserFromDb(
                        app,
                        userSession.id,
                        userDataSource,
                        call
                    )
                } catch (e: Exception) {
                    app.log.info("DELETING USER ERROR ${e.message}")
                    call.respondRedirect(Endpoint.Unauthorized.path)
                }
            }
        }
    }
}

private suspend fun deleteUserFromDb(
    app: Application,
    userId: String,
    userDataSource: UserDataSource,
    call: RoutingCall
) {
    val result = userDataSource.deleteUser(userId = userId)
    if (result) {
        app.log.info("USER SUCCESSFULLY DELETED")
        call.respond(
            message = ApiResponse(
                success = true,
                data = null
            ),
            status = HttpStatusCode.OK
        )
    } else {
        app.log.info("ERROR DELETING THE USER")
        call.respond(
            message = ApiResponse(
                success = false,
                data = null
            ),
            status = HttpStatusCode.BadRequest
        )
    }
}