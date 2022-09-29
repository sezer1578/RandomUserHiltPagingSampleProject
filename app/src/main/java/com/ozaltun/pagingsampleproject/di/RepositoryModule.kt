package com.ozaltun.pagingsampleproject.di

import com.ozaltun.pagingsampleproject.data.repository.UserRepository
import com.ozaltun.pagingsampleproject.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideUserRepository(userRepository: UserRepositoryImpl): UserRepository
}