package com.app.connect.data.remote

import com.app.connect.domain.model.User

interface AuthApi {
    suspend fun login(email: String, password: String): User
    suspend fun register(email: String, password: String): User
}
