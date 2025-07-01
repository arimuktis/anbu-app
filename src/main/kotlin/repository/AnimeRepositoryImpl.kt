package com.anbu.repository

import com.anbu.models.ApiResponse
import com.anbu.models.Anime

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
            id = 1,
            name = "Jujutsu Kaisen: Shibuya Jihen",
            image = "/images/sasuke.jpg",
            about = "Sasuke Uchiha kontole gedhi",
            rating = 5.0,
            power = 8,
            month = "July",
            day = "23rd",
            family = listOf("Fugaku", "Madara", "Mikoto", "Itachi", "Sarada"),
            abilities = listOf("kentu", "ndangak", "chidori"),
            natureTypes = listOf("human", "ninja"),
            genres = listOf("Action", "Sci-Fi", "Drama"),
            title = "Jujutsu Kaisen: Shibuya Jihen",
            episode = 12,
            thumbnailUrl = "https://i5.walmartimages.com/seo/Chainsaw-Man-Anime-Poster-Frameless-Gift-12-x-18-inch-30cm-x-46cm_6359bee6-6930-4115-a317-5e7362f89e1a.9d65e6cce69026b14dc9331cf557bc83.jpeg",
            isNew = true
        ),
        Anime(
            id = 2,
            name = "Kimetsu no Yaiba: Katanakaji no Sato-hen",
            image = "/images/naruto.jpg",
            about = "Naruto Uzumaki is the Seventh Hokage of the Hidden Leaf Village and a anime of the Fourth Great Ninja War. Orphaned at birth and shunned for harboring the Nine-Tails, Naruto grew into a powerful ninja through determination, friendship, and an unbreakable will. With Kurama's power and Sage Mode, he now protects the village with unmatched strength and compassion.",
            rating = 5.0,
            power = 10,
            month = "October",
            day = "10th",
            family = listOf("Minato", "Kushina", "Boruto", "Himawari", "Hinata"),
            abilities = listOf("Rasengan", "Shadow Clone", "Sage Mode"),
            natureTypes = listOf("Wind", "Yang"),
            genres = listOf("Action", "Dark Fantasy"),
            title = "Kimetsu no Yaiba: Katanakaji no Sato-hen",
            episode = 12,
            thumbnailUrl = "https://images-cdn.ubuy.co.id/633feb8bd279163476374ad1-japan-anime-manga-poster-jujutsu.jpg",
            isNew = false
        ),
        Anime(
            id = 3,
            name = "Sakura",
            image = "/images/sakura.jpg",
            about = "Sakura Haruno is a renowned medical ninja and a key member of Team 7. Once known for her temper and intelligence, she matured into one of the strongest kunoichi of her era under Tsunade’s training. She is known for her devastating chakra-enhanced strength and life-saving medical skills. Beyond the battlefield, she is a loving mother and a pillar of the new generation.",
            rating = 4.5,
            power = 7,
            month = "March",
            day = "28th",
            family = listOf("Sarada", "Sasuke"),
            abilities = listOf("Strength", "Healing", "Chakra Control"),
            natureTypes = listOf("Earth"),
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        )
    )

    override val page2: List<Anime> = listOf(
        Anime(
            id = 4,
            name = "Boruto",
            image = "/images/boruto.png",
            about = "Boruto Uzumaki is the son of the Seventh Hokage and heir to a powerful legacy. Though initially rebellious against his father’s ideals, Boruto possesses exceptional talent and leadership qualities. As a bearer of the Karma seal, he struggles with his destiny while striving to protect those he loves. His journey reflects both burden and brilliance.",
            rating = 4.2,
            power = 6,
            month = "March",
            day = "27th",
            family = listOf("Naruto", "Hinata", "Himawari"),
            abilities = listOf("Karma", "Rasengan", "Shadow Clone"),
            natureTypes = listOf("Lightning", "Wind"),
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        ),
        Anime(
            id = 5,
            name = "Sarada",
            image = "/images/sarada.jpg",
            about = "Sarada Uchiha is the prodigious daughter of Sasuke and Sakura, combining her father's analytical mind and Sharingan with her mother's strength. As a member of the new Team 7, she is determined to become Hokage one day and lead with wisdom and strength. She represents the future of the Uchiha clan and its redemption.",
            rating = 4.0,
            power = 6,
            month = "March",
            day = "31st",
            family = listOf("Sasuke", "Sakura"),
            abilities = listOf("Sharingan", "Chakra Strength"),
            natureTypes = listOf("Fire", "Lightning"),
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        ),
        Anime(
            id = 6,
            name = "Kawaki",
            image = "/images/kawaki.jpg",
            about = "Kawaki is a troubled yet powerful ninja who was once a vessel for Isshiki Ōtsutsuki. After escaping the Kara organization, he was taken in by Naruto and grew into a protective and loyal figure. Despite his rough past and inner turmoil, Kawaki is fiercely determined to forge his own path and defend the people he considers family.",
            rating = 4.3,
            power = 7,
            month = "June",
            day = "19th",
            family = listOf("Naruto"),
            abilities = listOf("Karma", "Absorption"),
            natureTypes = listOf("Unknown"),
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        )
    )

    override val page3: List<Anime> = listOf(
        Anime(
            id = 7,
            name = "Mitsuki",
            image = "/images/mitsuki.jpg",
            about = "Mitsuki is the calm and mysterious synthetic son of Orochimaru. Created through experimentation, Mitsuki possesses high intelligence and remarkable chakra control. Though enigmatic, he values friendship deeply, especially his bond with Boruto. His ability to enter Sage Mode makes him an extraordinary shinobi despite his young age.",
            rating = 4.1,
            power = 6,
            month = "July",
            day = "25th",
            family = listOf("Orochimaru"),
            abilities = listOf("Snake Clone", "Sage Mode"),
            natureTypes = listOf("Wind", "Lightning"),
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        ),
        Anime(
            id = 8,
            name = "Orochimaru",
            image = "/images/orochimaru.jpg",
            about = "Orochimaru is one of the most notorious and enigmatic figures in shinobi history. Once a Sannin of the Hidden Leaf, he sought immortality through forbidden techniques and unethical experimentation. Over time, he became more neutral, even aiding the village indirectly. His genius in jutsu and science remains unparalleled.",
            rating = 4.4,
            power = 8,
            month = "October",
            day = "27th",
            family = listOf("Mitsuki"),
            abilities = listOf("Reanimation", "Snake Jutsu"),
            natureTypes = listOf("All Types"),
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        ),
        Anime(
            id = 9,
            name = "Amado",
            image = "/images/amado.jpg",
            about = "Amado is a brilliant and secretive scientist who defected from Kara. His technological expertise rivals even Orochimaru’s, having developed advanced modifications and the Karma system. Though he often keeps his true intentions hidden, he plays a pivotal role in helping Konoha understand the Ōtsutsuki threat.",
            rating = 3.9,
            power = 5,
            month = "August",
            day = "15th",
            family = listOf("Unknown"),
            abilities = listOf("Scientific Enhancements", "Intel"),
            natureTypes = listOf("N/A"),
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        )
    )

    override val page4: List<Anime> = listOf(
        Anime(
            id = 10,
            name = "Koji Kashin",
            image = "/images/koji.jpg",
            about = "Koji Kashin is a mysterious shinobi created by Amado as a clone of the legendary Jiraiya. Infiltrating Kara, he acts as a spy and assassin with deep knowledge of shinobi tactics. Despite his origin, Koji shows a strong will and independence, embodying both his genetic heritage and a purpose of his own.",
            rating = 4.0,
            power = 7,
            month = "May",
            day = "12th",
            family = listOf("Unknown"),
            abilities = listOf("Toad Summoning", "Fire Style"),
            natureTypes = listOf("Fire", "Earth"),
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        ),
        Anime(
            id = 11,
            name = "Code",
            image = "/images/code.jpg",
            about = "Code is a devout follower of the Ōtsutsuki and the last active remnant of Kara. Enhanced with scientific tools and the bearer of White Karma, Code is an unstable yet incredibly powerful enemy. He seeks vengeance and the resurrection of the Ōtsutsuki ideals, making him one of the greatest threats to the shinobi world.",
            rating = 4.5,
            power = 9,
            month = "November",
            day = "3rd",
            family = listOf("Unknown"),
            abilities = listOf("White Karma", "Claw Marks"),
            natureTypes = listOf("Unknown"),
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        ),
        Anime(
            id = 12,
            name = "Kakashi",
            image = "/images/kakashi.png",
            about = "Kakashi Hatake, known as the Copy Ninja, served as the Sixth Hokage and is respected as a legendary shinobi. With a calm demeanor and sharp intellect, he mastered countless jutsu through his Sharingan. A loyal mentor and tactician, Kakashi's legacy continues to shape the future of the shinobi world.",
            rating = 4.9,
            power = 9,
            month = "September",
            day = "15th",
            family = listOf("Sakumo"),
            abilities = listOf("Sharingan", "Lightning Blade", "Ninjutsu Mastery"),
            natureTypes = listOf("Lightning", "Earth", "Water"),
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        )
    )

    override val page5: List<Anime> = listOf(
        Anime(
            id = 13,
            name = "Ishiki Otsutsuki",
            image = "/images/ishiki.jpg",
            about = "Ishiki Ōtsutsuki is a god-like alien whose purpose is to harvest planetary chakra through the God Tree. Cold, calculating, and overwhelmingly powerful, he possessed Jigen as a host and sought to implant Karma on Kawaki. His presence alone represents the peak of the Ōtsutsuki threat.",
            rating = 5.0,
            power = 10,
            month = "January",
            day = "1st",
            family = listOf("Jigen (host)"),
            abilities = listOf("Shrink Objects", "Karma"),
            natureTypes = listOf("Unknown"),
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        ),
        Anime(
            id = 14,
            name = "Momoshiki Otsutsuki",
            image = "/images/momoshiki.jpg",
            about = "Momoshiki Ōtsutsuki is a fearsome alien being driven by a divine hunger for power. After consuming his partner Kinshiki, he evolved into a monstrous form capable of devastating attacks. Even after his defeat, his spirit persists within Boruto, threatening to take over his body through Karma.",
            rating = 4.8,
            power = 10,
            month = "December",
            day = "14th",
            family = listOf("Kinshiki"),
            abilities = listOf("Absorb Jutsu", "God Tree Transformation"),
            natureTypes = listOf("All Types"),
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        ),
        Anime(
            id = 15,
            name = "Urashiki Otsutsuki",
            image = "/images/urashiki.jpg",
            about = "Urashiki Ōtsutsuki is a cunning and playful member of the alien Ōtsutsuki clan. Gifted with the Rinnegan and time-based abilities, he toyed with time travel in an attempt to rewrite history. Unlike his kin, Urashiki used trickery and chaos to pursue his goals, making him a dangerous and unpredictable adversary.",
            rating = 4.2,
            power = 8,
            month = "April",
            day = "7th",
            family = listOf("Otsutsuki clan"),
            abilities = listOf("Time Manipulation", "Rinnegan"),
            natureTypes = listOf("Unknown"),
            genres = listOf("Adventure", "Historical", "Supernatural"),
            title = "Sakura",
            episode = 12,
            thumbnailUrl = "https://image.tmdb.org/t/p/original/8rWeMJTPMHnttbyU2em5kIGB1q7.jpg",
            isNew = false
        )
    )

    override suspend fun getAllAnimes(page: Int): ApiResponse {
        return ApiResponse(
            success = true,
            message = OK,
            prevPage = calculatePage(page)[PREVIOUS_PAGE_KEY],
            nextPage = calculatePage(page)[NEXT_PAGE_KEY],
            animes = animes[page].orEmpty(),
            lastUpdated = System.currentTimeMillis()
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

    override suspend fun searchAnime(name: String?): ApiResponse {
        return ApiResponse(
            success = true,
            message = OK,
            animes = findAnimes(query = name)
        )
    }

    private fun findAnimes(query: String?): List<Anime> {
        val founded = mutableListOf<Anime>()

        return if (!query.isNullOrEmpty()) {
            animes.forEach { (_, animes) ->
                animes.forEach { anime ->
                    if (anime.name.lowercase().contains(query.lowercase())) {
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