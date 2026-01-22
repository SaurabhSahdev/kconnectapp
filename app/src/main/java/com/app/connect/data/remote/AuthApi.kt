package com.practice.jetpackpractice.data.remote

import com.practice.jetpackpractice.domain.model.User

interface AuthApi {
    suspend fun login(email: String, password: String): User
    suspend fun register(email: String, password: String): User
}