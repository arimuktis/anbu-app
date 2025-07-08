package com.anbu.domain.models

import io.ktor.server.auth.Principal
import kotlinx.serialization.Serializable

@Serializable
data class UserSession(
    val id: String,
    val name: String
) : Principal
