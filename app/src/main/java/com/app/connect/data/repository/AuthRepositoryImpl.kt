package com.practice.jetpackpractice.data.repository

import com.practice.jetpackpractice.data.remote.AuthApi
import com.practice.jetpackpractice.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val api: AuthApi
) : AuthRepository {

    override suspend fun login(email: String, password: String) =
        api.login(email, password)

    override suspend fun register(email: String, password: String) =
        api.register(email, password)
}
