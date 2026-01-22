package com.practice.jetpackpractice.di

import com.practice.jetpackpractice.data.remote.AuthApi
import com.practice.jetpackpractice.data.remote.MockAuthApi
import com.practice.jetpackpractice.data.repository.AuthRepositoryImpl
import com.practice.jetpackpractice.domain.repository.AuthRepository
import com.practice.jetpackpractice.domain.usecase.LoginUseCase
import com.practice.jetpackpractice.domain.usecase.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideAuthApi(): AuthApi = MockAuthApi()

    @Provides
    fun provideAuthRepository(api: AuthApi): AuthRepository =
        AuthRepositoryImpl(api)

    @Provides
    fun provideLoginUseCase(repo: AuthRepository) = LoginUseCase(repo)

    @Provides
    fun provideRegisterUseCase(repo: AuthRepository) = RegisterUseCase(repo)
}
