package com.android.example.assignment2.network

import com.android.example.assignment2.models.Entity
import com.android.example.assignment2.models.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {
    @POST("auth")
    suspend fun authoriseUser(@Body data: User): User

    @GET("dashboard/{keypass}")
    suspend fun getCourses(): Entity
}