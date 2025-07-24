package com.anbu.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Episode(
    val number: Int,
    val title: String,
    val like: Int? = 0,
    val watch: Int? = 0,
    val liked: Boolean? = false,
    val watched: Boolean? = false,
    val videoPath: String,
    val thumbnail: String,
    val duration: Int,
    val available: Boolean
)