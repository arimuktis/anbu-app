package com.anbu.data.repository

import com.anbu.domain.models.bunny.CollectionListResponse
import com.anbu.domain.models.bunny.VideoListResponse
import io.github.cdimascio.dotenv.dotenv
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class BunnyDataSourceImpl(
    private val client: HttpClient
) : BunnyDataSource {

    val dotenv = dotenv {
        ignoreIfMalformed = true
        ignoreIfMissing = true
    }

    private val libraryId = dotenv["BUNNY_LIBRARY_ID"]
    private val apiKey = dotenv["BUNNY_API_KEY"]
    override suspend fun getCollections(): CollectionListResponse =
        client.get("https://video.bunnycdn.com/library/$libraryId/collections") {
            header("AccessKey", apiKey)
        }.body()


    override suspend fun getVideos(collectionGuid: String): VideoListResponse =
        client.get("https://video.bunnycdn.com/library/$libraryId/videos") {
            parameter("collection", collectionGuid)
            header("AccessKey", apiKey)
        }.body()
}