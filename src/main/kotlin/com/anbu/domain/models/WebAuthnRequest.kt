package com.anbu.domain.models


@kotlinx.serialization.Serializable
data class WebAuthnRequest(
    val challenge: String,
    val rpId: String,
    val userId: String
)

@kotlinx.serialization.Serializable
data class WebAuthnResponse(
    val id: String,
    val rawId: String,
    val response: String,
    val type: String
)

@kotlinx.serialization.Serializable
data class GoogleScanLoginInfo(
    val accessToken: String,
    val refreshToken: String,
    val email: String
)