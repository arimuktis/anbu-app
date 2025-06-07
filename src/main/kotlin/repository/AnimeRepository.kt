package com.anbu.repository

import com.anbu.models.Anime
import com.anbu.models.ApiResponse

interface AnimeRepository {

    val animes: Map<Int, List<Anime>>

    val page1: List<Anime>
    val page2: List<Anime>
    val page3: List<Anime>
    val page4: List<Anime>
    val page5: List<Anime>

    suspend fun getAllAnimes(page: Int = 1): ApiResponse
    suspend fun searchAnime(name: String): ApiResponse
}