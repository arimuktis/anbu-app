package com.anbu.di

import com.anbu.data.repository.UserDataSource
import com.anbu.data.repository.UserDataSourceImpl
import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import org.koin.dsl.module

val mongoModule = module {

    single<MongoClient> {
        val mongoUri = System.getenv("MONGO_DB_URI")
            ?: error("Missing MONGO_DB_URI env variable")
        MongoClient.create(mongoUri)
    }

    single<MongoDatabase> {
        val client = get<MongoClient>()
        val dbName = System.getenv("MONGO_DB_NAME") ?: "anbuapp"
        client.getDatabase(dbName)
    }

    single<UserDataSource> {
        UserDataSourceImpl(get())
    }
}