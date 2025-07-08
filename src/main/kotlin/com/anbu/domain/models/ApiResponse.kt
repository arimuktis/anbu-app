package com.anbu.domain.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    val success: Boolean,
    val message: String? = null,
    @Contextual val data: T? = null
)