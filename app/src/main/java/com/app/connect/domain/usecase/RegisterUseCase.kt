package com.practice.jetpackpractice.domain.usecase

import com.app.connect.domain.repository.AuthRepository


class RegisterUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) =
        repository.register(email, password)
}