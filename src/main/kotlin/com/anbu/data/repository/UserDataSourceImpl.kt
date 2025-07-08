package com.anbu.data.repository

import com.anbu.domain.models.User
import com.mongodb.client.model.Filters.eq
import com.mongodb.client.model.UpdateOptions
import com.mongodb.client.model.Updates
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import kotlinx.coroutines.flow.firstOrNull
import org.bson.Document

class UserDataSourceImpl(
    val database: MongoDatabase
): UserDataSource {

    private val users = database.getCollection<User>(
        collectionName = "users"
    )

    override suspend fun getUserInfo(userId: String): User? {
        return users.find(eq("id", userId)).firstOrNull()
    }

    override suspend fun saveUserInfo(user: User): Boolean {
        val existing = users.find(Document("id", user.id)).firstOrNull()
        return if (existing == null) {
            users.insertOne(user).wasAcknowledged()
        } else {
            true
        }
    }


    override suspend fun deleteUser(userId: String): Boolean {
        val result = users.deleteOne(Document("id", userId))
        return result.deletedCount > 0
    }

    override suspend fun updateUserInfo(
        userId: String,
        firstName: String,
        lastName: String
    ): Boolean {
        val filter = Document("id", userId) // or "_id" with ObjectId(userId)
        val update = Updates.combine(
            Updates.set("firstName", firstName),
            Updates.set("lastName", lastName)
        )

        val result = users.updateOne(filter, update, UpdateOptions().upsert(false))
        return result.modifiedCount > 0
    }
}