package com.anbu.database

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import io.github.cdimascio.dotenv.dotenv
import org.koin.dsl.module

class MongoDatabaseFactory(connectionString: String) {
    private val client = MongoClient.create(connectionString)
    val db: MongoDatabase = client.getDatabase("anbuapp")
}

val mongoModule = module {
    single<MongoDatabaseFactory> {
        val envName = System.getenv("ENV") ?: "dev"
        val dotenv = dotenv {
            filename = ".env.$envName"
            ignoreIfMissing = true
        }

        val mongoUri = dotenv["MONGO_DB_URI"] ?: error("Missing MONGO_DB_URI")
        println("Mongo URI loaded: $mongoUri") // DEBUGGING SAJA
        MongoDatabaseFactory(mongoUri)
    }
    single<MongoDatabase> { get<MongoDatabaseFactory>().db }
}