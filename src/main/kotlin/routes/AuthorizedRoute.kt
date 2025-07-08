package com.anbu.routes

import com.anbu.domain.models.ApiResponse
import com.anbu.domain.models.Endpoint
import io.ktor.http.HttpStatusCode
import io.ktor.server.auth.authenticate
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.authorizedRoute() {
   authenticate("auth-session") {
       get(Endpoint.Authorized.path) {
           call.respond(
               message = ApiResponse<Unit>(success = true),
               status = HttpStatusCode.OK
           )
       }
   }
}