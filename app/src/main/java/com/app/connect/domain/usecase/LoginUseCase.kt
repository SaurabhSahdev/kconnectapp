package com.app.connect.domain.usecase

import com.app.connect.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) =
        repository.login(email, password)
}
