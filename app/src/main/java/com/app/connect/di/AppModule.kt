package com.app.connect.di

import com.app.connect.data.remote.AuthApi
import com.app.connect.data.remote.MockAuthApi
import com.app.connect.data.repository.AuthRepositoryImpl
import com.app.connect.domain.repository.AuthRepository
import com.app.connect.domain.usecase.LoginUseCase
import com.practice.jetpackpractice.domain.usecase.RegisterUseCase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAuthApi(): AuthApi = MockAuthApi()

    @Provides
    @Singleton
    fun provideAuthRepository(api: AuthApi): AuthRepository =
        AuthRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideLoginUseCase(repo: AuthRepository) = LoginUseCase(repo)

    @Provides
    @Singleton
    fun provideRegisterUseCase(repo: AuthRepository) = RegisterUseCase(repo)
}
