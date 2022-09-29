package com.ozaltun.pagingsampleproject.data.remote

import com.ozaltun.pagingsampleproject.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api")
    suspend fun getAllUsers(
        @Query("page") page: Int,
        @Query("results") results: Int
    ): Response<UserResponse>
}