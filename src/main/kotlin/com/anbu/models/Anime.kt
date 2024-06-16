package com.anbu.models

import kotlinx.serialization.Serializable

@Serializable
data class Anime(
    val id: Int,
    val name: String,
    val image: String,
    val about: String,
    val rating: Double,
    val month: String,
    val day: String,
    val genres: List<String>
)
