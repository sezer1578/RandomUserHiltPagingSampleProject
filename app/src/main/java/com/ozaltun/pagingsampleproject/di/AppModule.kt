package com.ozaltun.pagingsampleproject.di

import com.ozaltun.pagingsampleproject.data.remote.ApiService
import com.ozaltun.pagingsampleproject.data.repository.UserRepository
import com.ozaltun.pagingsampleproject.data.repository.UserRepositoryImpl
import com.ozaltun.pagingsampleproject.util.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL


    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL: String): ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
}