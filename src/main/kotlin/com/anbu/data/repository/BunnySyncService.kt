package com.anbu.data.repository

import com.anbu.domain.models.Anime
import com.anbu.domain.models.Episode
import com.anbu.domain.models.bunny.BunnyCollection
import com.anbu.domain.models.bunny.BunnyVideo
import com.mongodb.client.model.UpdateOptions
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import org.bson.Document

class BunnySyncService(
    private val bunny: BunnyDataSource,
    private val db: MongoDatabase
) {
    // Mongo collection handle
    private val animeCol = db.getCollection<Anime>("animes")

    suspend fun syncAll() {
        val collections = bunny.getCollections().items
        collections.forEach { coll ->
            val videos = bunny.getVideos(coll.guid).items
            val doc    = coll.toAnimeDoc(videos)
            val filter = Document("id", doc.id)
            val update = Document("\$set", doc)
            animeCol.updateOne(filter, update, UpdateOptions().upsert(true))
        }
    }

    // ----------------- MAPPERS -----------------

    private fun BunnyCollection.toAnimeDoc(videos: List<BunnyVideo>): Anime {
        val slug = name.toSlug()

        val eps = videos
            .mapNotNull { it.toEpisode(it.guid, slug) }
            .sortedBy { it.number }

        return Anime(
            id          = guid,
            title       = name,
            episode     = eps.size,
            image       = "https://anbu-app.b-cdn.net/images/$slug.jpg",
            thumbnailUrl= "https://anbu-app.b-cdn.net/thumbnails/$slug.jpg",
            rating      = 0.0,
            description = "TODO()",
            genres      = listOf("Anime"),
            episodes    = eps,
            isNew       = false
        )
    }

    private fun BunnyVideo.toEpisode(guid: String, slug: String): Episode? {
        val episodeNo = Regex("""_(\d{2})""")
            .find(title)
            ?.groupValues
            ?.get(1)
            ?.toInt() ?: return null

        return Episode(
            number    = episodeNo,
            title     = "Episode $episodeNo",
            videoPath = guid,
            duration  = length,
            thumbnail = "https://anbu-app.b-cdn.net/thumbnails/$slug-$episodeNo.jpg",
            available = status == 4
        )
    }

}

/* ---------- helpers / models ---------- */

private fun String.toSlug(): String =
    lowercase().replace(Regex("[^a-z0-9]+"), "-").trim('-')


