package com.anbu.data.repository

import com.anbu.domain.models.User

interface UserDataSource {
    suspend fun getUserInfo(userId: String): User?
    suspend fun saveUserInfo(user: User): Boolean
    suspend fun deleteUser(userId: String): Boolean
    suspend fun updateUserInfo(userId: String, firstName: String, lastName: String): Boolean
    suspend fun updateUserSubscription(userId: String, isPremium: Boolean): Boolean
}