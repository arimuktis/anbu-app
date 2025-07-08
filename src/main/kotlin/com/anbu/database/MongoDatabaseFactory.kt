package com.anbu.database

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import org.koin.dsl.module

class MongoDatabaseFactory {
    private val connectionString = System.getenv("MONGO_DB_URI")
    private val client = MongoClient.create(connectionString)
    val db: MongoDatabase = client.getDatabase("anbuapp")
}

val mongoModule = module {
    single { MongoDatabaseFactory() }
    single<MongoDatabase> { get<MongoDatabaseFactory>().db }
}