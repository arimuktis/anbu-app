package com.anbu.database

import com.mongodb.kotlin.client.coroutine.MongoClient

class MongoDatabaseFactory {

    private val connectionString = System.getenv("MONGO_DB_URI")

    private val db = MongoClient
        .create(connectionString)
        .getDatabase("anbuapp")
}