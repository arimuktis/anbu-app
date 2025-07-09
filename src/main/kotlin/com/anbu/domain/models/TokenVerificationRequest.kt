package com.anbu.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class TokenVerificationRequest(
    val tokenId: String
)
