package com.android.example.assignment2.network


import com.android.example.assignment2.models.CourseList
import com.android.example.assignment2.models.KeyPass
import com.android.example.assignment2.models.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("auth")
    suspend fun authoriseUser(@Body data: User): KeyPass

    @GET("dashboard/{keypass}")
    suspend fun getCourses(@Path("keypass") keypass : String) : CourseList
}