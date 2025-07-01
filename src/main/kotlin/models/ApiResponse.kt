package com.anbu.models

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? = null,
    val animes: List<Anime> = emptyList(),
    val lastUpdated: Long? = null
)