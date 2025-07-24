package com.anbu.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Anime(
    val id: String,
    val title: String,
    val episode: Int,
    val like: Int? = 0,
    val watch: Int? = 0,
    val liked: Boolean? = false,
    val watched: Boolean? = false,
    val image: String,
    val thumbnailUrl: String,
    val rating: Double,
    val description: String,
    val genres: List<String>,
    val episodes: List<Episode>,
    val isNew: Boolean
)