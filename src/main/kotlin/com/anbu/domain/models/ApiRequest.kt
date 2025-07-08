package com.anbu.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class ApiRequest(
    val tokenId: String
)
