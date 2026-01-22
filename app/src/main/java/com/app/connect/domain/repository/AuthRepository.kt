package com.practice.jetpackpractice.domain.repository

import com.practice.jetpackpractice.domain.model.User

interface AuthRepository {
    suspend fun login(email: String, password: String): User
    suspend fun register(email: String, password: String): User
}
