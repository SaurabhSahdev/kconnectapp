package com.app.connect.domain.repository

import com.app.connect.domain.model.User

interface AuthRepository {
    suspend fun login(email: String, password: String): User
    suspend fun register(email: String, password: String): User
}
