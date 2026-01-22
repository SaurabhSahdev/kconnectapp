package com.practice.jetpackpractice.data.remote

import com.practice.jetpackpractice.domain.model.User
import kotlinx.coroutines.delay

class MockAuthApi : AuthApi {

    override suspend fun login(email: String, password: String): User {
        delay(1500)
        return User(email, "mock_token_123")
    }

    override suspend fun register(email: String, password: String): User {
        delay(1500)
        return User(email, "mock_token_456")
    }
}
