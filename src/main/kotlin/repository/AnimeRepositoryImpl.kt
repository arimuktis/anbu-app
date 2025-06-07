package com.anbu.repository

import com.anbu.models.Anime
import com.anbu.models.ApiResponse

class AnimeRepositoryImpl: AnimeRepository {

    override val animes: Map<Int, List<Anime>>
        get() = TODO("Not yet implemented")
    override val page1: List<Anime>
        get() = TODO("Not yet implemented")
    override val page2: List<Anime>
        get() = TODO("Not yet implemented")
    override val page3: List<Anime>
        get() = TODO("Not yet implemented")
    override val page4: List<Anime>
        get() = TODO("Not yet implemented")
    override val page5: List<Anime>
        get() = TODO("Not yet implemented")

    override suspend fun getAllAnimes(page: Int): ApiResponse {
        TODO("Not yet implemented")
    }

    override suspend fun searchAnime(name: String): ApiResponse {
        TODO("Not yet implemented")
    }
}