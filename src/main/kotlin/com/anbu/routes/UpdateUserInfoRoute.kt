package com.anbu.routes

import com.anbu.data.repository.UserDataSource
import com.anbu.domain.models.ApiResponse
import com.anbu.domain.models.Endpoint
import com.anbu.domain.models.UserSession
import com.anbu.domain.models.UserUpdate
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.updateUserRoute(
    app: Application,
    userDataSource: UserDataSource
) {
    authenticate("auth-session") {
        put(Endpoint.UpdateUserInfo.path) {
            val userSession = call.principal<UserSession>()
            val userUpdate = call.receive<UserUpdate>()
            if (userSession == null) {
                app.log.info("INVALID SESSION")
                call.respondRedirect(Endpoint.Unauthorized.path)
            } else {
                try {
                    updateUserInfo(
                        app = app,
                        userId = userSession.id,
                        userUpdate = userUpdate,
                        userDataSource = userDataSource,
                        call = call
                    )
                } catch (e: Exception) {
                    app.log.info("UPDATE USER INFO ERROR: $e")
                    call.respondRedirect(Endpoint.Unauthorized.path)
                }
            }
        }
    }
}

private suspend fun updateUserInfo(
    app: Application,
    userId: String,
    userUpdate: UserUpdate,
    userDataSource: UserDataSource,
    call: RoutingCall
) {
    val response = userDataSource.updateUserInfo(
        userId = userId,
        firstName = userUpdate.firstName,
        lastName = userUpdate.lastName
    )

    if (response) {
        app.log.info("USER SUCCESSFULLY UPDATED")
        call.respond(
            message = ApiResponse(
                success = true,
                data = null,
                message = "Successfully Updated!"
            ),
            status = HttpStatusCode.OK
        )
    } else {
        app.log.info("ERROR UPDATING THE USER")
        call.respond(
            message = ApiResponse(
                success = false,
                data = null
            ),
            status = HttpStatusCode.BadRequest
        )
    }
}