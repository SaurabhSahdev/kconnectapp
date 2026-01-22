package com.practice.jetpackpractice.domain.usecase

import com.practice.jetpackpractice.domain.repository.AuthRepository

class RegisterUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) =
        repository.register(email, password)
}