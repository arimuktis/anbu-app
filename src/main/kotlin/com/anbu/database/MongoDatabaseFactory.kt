package com.anbu.database

import com.anbu.data.repository.UserDataSource
import com.anbu.data.repository.UserDataSourceImpl
import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import io.github.cdimascio.dotenv.dotenv
import org.koin.dsl.module

val mongoModule = module {

    val dotenv = dotenv {
        ignoreIfMalformed = true
        ignoreIfMissing = true
    }

    single<MongoClient> {
        val mongoUri = dotenv["MONGO_DB_URI"]
            ?: error("Missing MONGO_DB_URI env variable")
        MongoClient.create(mongoUri)
    }

    single<MongoDatabase> {
        val client = get<MongoClient>()
        val dbName = dotenv["MONGO_DB_NAME"] ?: "anbuapp"
        client.getDatabase(dbName)
    }

    single<UserDataSource> {
        UserDataSourceImpl(get())
    }
}