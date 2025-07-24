package com.anbu.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val name: String,
    val emailAddress: String,
    val profilePhoto: String,
    val isPremium: Boolean = false,
    val likedAnime: List<String>? = emptyList(),
    val likedEpisode: List<String>? = emptyList(),
    val watchedAnime: List<String>? = emptyList(),
    val watchedEpisode: List<String>? = emptyList(),
    val historyWatchedAnime: List<String>? = emptyList()
)