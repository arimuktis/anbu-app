package com.anbu.data.repository

import com.anbu.domain.models.bunny.CollectionListResponse
import com.anbu.domain.models.bunny.VideoListResponse

interface BunnyDataSource {
    suspend fun getCollections(): CollectionListResponse
    suspend fun getVideos(collectionGuid: String): VideoListResponse
}