package com.anbu.models

import kotlinx.serialization.Serializable

@Serializable
data class Anime(
    val id: Int,
    val name: String,
    val title: String,
    val episode: Int,
    val image: String,
    val thumbnailUrl: String,
    val about: String,
    val rating: Double,
    val power: Int,
    val month: String,
    val day: String,
    val family: List<String>,
    val abilities: List<String>,
    val natureTypes: List<String>,
    val genres: List<String>,
    val isNew: Boolean
)