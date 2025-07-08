package com.anbu.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class AnimeData(
    val prevPage: Int? = null,
    val nextPage: Int? = null,
    val animes: List<Anime> = emptyList(),
    val lastUpdated: Long? = null
)
