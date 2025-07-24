package com.anbu.data.repository

import com.anbu.domain.models.ApiResponse
import com.anbu.domain.models.Anime
import com.anbu.domain.models.AnimeData

const val NEXT_PAGE_KEY = "nextPage"
const val PREVIOUS_PAGE_KEY = "prevPage"
const val OK = "ok"

class AnimeRepositoryImpl : AnimeRepository {
    override val animes: Map<Int, List<Anime>> by lazy {
        mapOf(
            1 to page1,
            2 to page2,
            3 to page3,
            4 to page4,
            5 to page5
        )
    }

    override val page1: List<Anime> = listOf(
        Anime(
            id = "1",
            title = "Jujutsu Kaisen: Shibuya Jihen",
            image = "/images/sasuke.jpg",
            rating = 5.0,
            description = "",
            episodes = emptyList(),
            genres = listOf("Action", "Sci-Fi", "Drama"),
            episode = 12,
            thumbnailUrl = "https://i5.walmartimages.com/seo/Chainsaw-Man-Anime-Poster-Frameless-Gift-12-x-18-inch-30cm-x-46cm_6359bee6-6930-4115-a317-5e7362f89e1a.9d65e6cce69026b14dc9331cf557bc83.jpeg",
            isNew = true
        ),
        Anime(
            id = "1",
            image = "/images/naruto.jpg",
            rating = 5.0,
            genres = listOf("Action", "Dark Fantasy"),
            title = "Kimetsu no Yaiba: Katanakaji no Sato-hen",
            description = "",
            episodes = emptyList(),
            episode = 12,
            thumbnailUrl = "https://images-cdn.ubuy.co.id/633feb8bd279163476374ad1-japan-anime-manga-poster-jujutsu.jpg",
            isNew = false
        ),
        Anime(
            id = "1",
            image = "/images/sakura.jpg",
            rating = 4.5,
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            description = "",
            episodes = emptyList(),
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        )
    )

    override val page2: List<Anime> = listOf(
        Anime(
            id = "1",
            image = "/images/boruto.png",
            description = "Boruto Uzumaki is the son of the Seventh Hokage and heir to a powerful legacy. Though initially rebellious against his father’s ideals, Boruto possesses exceptional talent and leadership qualities. As a bearer of the Karma seal, he struggles with his destiny while striving to protect those he loves. His journey reflects both burden and brilliance.",
            rating = 4.2,
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episodes = emptyList(),
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        ),
        Anime(
            id = "1",
            image = "/images/sarada.jpg",
            description = "Sarada Uchiha is the prodigious daughter of Sasuke and Sakura, combining her father's analytical mind and Sharingan with her mother's strength. As a member of the new Team 7, she is determined to become Hokage one day and lead with wisdom and strength. She represents the future of the Uchiha clan and its redemption.",
            rating = 4.0,
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episodes = emptyList(),
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        ),
        Anime(
            id = "1",
            image = "/images/kawaki.jpg",
            description = "Kawaki is a troubled yet powerful ninja who was once a vessel for Isshiki Ōtsutsuki. After escaping the Kara organization, he was taken in by Naruto and grew into a protective and loyal figure. Despite his rough past and inner turmoil, Kawaki is fiercely determined to forge his own path and defend the people he considers family.",
            rating = 4.3,
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episodes = emptyList(),
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        )
    )

    override val page3: List<Anime> = listOf(
        Anime(
            id = "1",
            image = "/images/mitsuki.jpg",
            description = "Mitsuki is the calm and mysterious synthetic son of Orochimaru. Created through experimentation, Mitsuki possesses high intelligence and remarkable chakra control. Though enigmatic, he values friendship deeply, especially his bond with Boruto. His ability to enter Sage Mode makes him an extraordinary shinobi despite his young age.",
            rating = 4.1,
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episodes = emptyList(),
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        ),
        Anime(
            id = "1",
            image = "/images/orochimaru.jpg",
            description = "Orochimaru is one of the most notorious and enigmatic figures in shinobi history. Once a Sannin of the Hidden Leaf, he sought immortality through forbidden techniques and unethical experimentation. Over time, he became more neutral, even aiding the village indirectly. His genius in jutsu and science remains unparalleled.",
            rating = 4.4,
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episodes = emptyList(),
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        ),
        Anime(
            id = "1",
            image = "/images/amado.jpg",
            description = "Amado is a brilliant and secretive scientist who defected from Kara. His technological expertise rivals even Orochimaru’s, having developed advanced modifications and the Karma system. Though he often keeps his true intentions hidden, he plays a pivotal role in helping Konoha understand the Ōtsutsuki threat.",
            rating = 3.9,
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episodes = emptyList(),
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        )
    )

    override val page4: List<Anime> = listOf(
        Anime(
            id = "1",
            image = "/images/koji.jpg",
            description = "Koji Kashin is a mysterious shinobi created by Amado as a clone of the legendary Jiraiya. Infiltrating Kara, he acts as a spy and assassin with deep knowledge of shinobi tactics. Despite his origin, Koji shows a strong will and independence, embodying both his genetic heritage and a purpose of his own.",
            rating = 4.0,
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episodes = emptyList(),
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        ),
        Anime(
            id = "1",
            image = "/images/code.jpg",
            description = "Code is a devout follower of the Ōtsutsuki and the last active remnant of Kara. Enhanced with scientific tools and the bearer of White Karma, Code is an unstable yet incredibly powerful enemy. He seeks vengeance and the resurrection of the Ōtsutsuki ideals, making him one of the greatest threats to the shinobi world.",
            rating = 4.5,
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episodes = emptyList(),
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        ),
        Anime(
            id = "1",
            image = "/images/kakashi.png",
            description = "Kakashi Hatake, known as the Copy Ninja, served as the Sixth Hokage and is respected as a legendary shinobi. With a calm demeanor and sharp intellect, he mastered countless jutsu through his Sharingan. A loyal mentor and tactician, Kakashi's legacy continues to shape the future of the shinobi world.",
            rating = 4.9,
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episodes = emptyList(),
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        )
    )

    override val page5: List<Anime> = listOf(
        Anime(
            id = "1",
            image = "/images/ishiki.jpg",
            description = "Ishiki Ōtsutsuki is a god-like alien whose purpose is to harvest planetary chakra through the God Tree. Cold, calculating, and overwhelmingly powerful, he possessed Jigen as a host and sought to implant Karma on Kawaki. His presence alone represents the peak of the Ōtsutsuki threat.",
            rating = 5.0,
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episodes = emptyList(),
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        ),
        Anime(
            id = "1",
            image = "/images/momoshiki.jpg",
            description = "Momoshiki Ōtsutsuki is a fearsome alien being driven by a divine hunger for power. After consuming his partner Kinshiki, he evolved into a monstrous form capable of devastating attacks. Even after his defeat, his spirit persists within Boruto, threatening to take over his body through Karma.",
            rating = 4.8,
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episodes = emptyList(),
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        ),
        Anime(
            id = "1",
            image = "/images/urashiki.jpg",
            description = "Urashiki Ōtsutsuki is a cunning and playful member of the alien Ōtsutsuki clan. Gifted with the Rinnegan and time-based abilities, he toyed with time travel in an attempt to rewrite history. Unlike his kin, Urashiki used trickery and chaos to pursue his goals, making him a dangerous and unpredictable adversary.",
            rating = 4.2,
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episodes = emptyList(),
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        )
    )

    override suspend fun getAllAnimes(page: Int): ApiResponse<AnimeData> {
        val prevPage = calculatePage(page)[PREVIOUS_PAGE_KEY]
        val nextPage = calculatePage(page)[NEXT_PAGE_KEY]
        val animeList = animes[page].orEmpty()

        return ApiResponse(
            success = true,
            message = OK,
            data = AnimeData(
                prevPage = prevPage,
                nextPage = nextPage,
                animes = animeList,
                lastUpdated = System.currentTimeMillis()
            )
        )
    }


    private fun calculatePage(page: Int): Map<String, Int?> {
        var prevPage: Int? = page
        var nextPage: Int? = page
        if (page in 1..4) {
            nextPage = nextPage?.plus(1)
        }
        if (page in 2..5) {
            prevPage = prevPage?.minus(1)
        }
        if (page == 1) {
            prevPage = null
            nextPage = page.plus(1)
        }
        if (page == 5) {
            prevPage = page.minus(1)
            nextPage = null
        }

        return mapOf(PREVIOUS_PAGE_KEY to prevPage, NEXT_PAGE_KEY to nextPage)
    }

    override suspend fun searchAnime(name: String?): ApiResponse<AnimeData> {
        val animeList = findAnimes(query = name)

        return ApiResponse(
            success = true,
            message = OK,
            data = AnimeData(
                animes = animeList,
                lastUpdated = System.currentTimeMillis()
            )
        )
    }

    private fun findAnimes(query: String?): List<Anime> {
        val founded = mutableListOf<Anime>()

        return if (!query.isNullOrEmpty()) {
            animes.forEach { (_, animes) ->
                animes.forEach { anime ->
                    if (anime.title.lowercase().contains(query.lowercase())) {
                        founded.add(anime)
                    }
                }
            }
            founded
        } else {
            emptyList()
        }
    }
}