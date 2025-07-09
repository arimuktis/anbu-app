package com.anbu.database

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import io.github.cdimascio.dotenv.dotenv
import org.koin.dsl.module

class MongoDatabaseFactory {
    private val connectionString = System.getenv("MONGO_DB_URI") ?: error("Missing MONGO_DB_URI env")
    private val client = MongoClient.create(connectionString)
    val db: MongoDatabase = client.getDatabase("anbuapp")
}

val mongoModule = module {
    single<MongoDatabaseFactory> {
//        val envName = System.getenv("ENV") ?: "dev"
//        val dotenv = dotenv {
//            filename = ".env.$envName"
//            ignoreIfMissing = true
//        }
//
//        val mongoUri = dotenv["MONGO_DB_URI"] ?: error("Missing MONGO_DB_URI")
        MongoDatabaseFactory()
    }
    single<MongoDatabase> { get<MongoDatabaseFactory>().db }
}