package com.anbu.models

import kotlinx.serialization.Serializable

@Serializable
data class AnimeHeadline(
    val headline: String,
    val animes: List<Anime>
)