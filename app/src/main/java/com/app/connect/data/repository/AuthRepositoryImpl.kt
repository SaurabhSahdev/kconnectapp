package com.app.connect.data.repository

import com.app.connect.data.remote.AuthApi
import com.app.connect.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val api: AuthApi
) : AuthRepository {

    override suspend fun login(email: String, password: String) =
        api.login(email, password)

    override suspend fun register(email: String, password: String) =
        api.register(email, password)
}
