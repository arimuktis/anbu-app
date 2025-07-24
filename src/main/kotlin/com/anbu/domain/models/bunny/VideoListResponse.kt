package com.anbu.domain.models.bunny

import kotlinx.serialization.Serializable

@Serializable
data class VideoListResponse(
    val totalItems: Int,
    val currentPage: Int,
    val itemsPerPage: Int,
    val items: List<BunnyVideo>
)

@Serializable
data class BunnyVideo(
    val videoLibraryId: Long,
    val guid: String,
    val title: String,
    val description: String? = null,
    val dateUploaded: String? = null,
    val views: Int,
    val isPublic: Boolean,
    val length: Int,
    val status: Int,
    val framerate: Double,
    val rotation: Int,
    val width: Int,
    val height: Int,
    val availableResolutions: String? = null,
    val outputCodecs: String? = null,
    val thumbnailCount: Int,
    val encodeProgress: Int,
    val storageSize: Long,
    val captions: List<String> = emptyList(),
    val hasMP4Fallback: Boolean,
    val collectionId: String,
    val thumbnailFileName: String? = null,
    val averageWatchTime: Int,
    val totalWatchTime: Int,
    val category: String? = null,
    val chapters: List<String> = emptyList(),
    val moments: List<String> = emptyList(),
    val metaTags: List<String> = emptyList(),
    val transcodingMessages: List<String> = emptyList(),
    val jitEncodingEnabled: Boolean
)
