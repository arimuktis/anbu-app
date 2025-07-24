package com.anbu.domain.models.bunny

import kotlinx.serialization.Serializable

@Serializable
data class CollectionListResponse(
    val totalItems: Int,
    val currentPage: Int,
    val itemsPerPage: Int,
    val items: List<BunnyCollection>
)

@Serializable
data class BunnyCollection(
    val videoLibraryId: Long,
    val guid: String,
    val name: String,
    val videoCount: Int,
    val totalSize: Long,
    val previewVideoIds: String,
    val previewImageUrls: List<String>
)