package com.android.example.assignment2.network

import com.android.example.assignment2.models.CourseList
import com.android.example.assignment2.models.KeyPass
import com.android.example.assignment2.models.User
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun authoriseUser(newObject: User) : KeyPass {
        return apiService.authoriseUser(newObject)
    }

    suspend fun getCourses(keypass: String): CourseList {
        return apiService.getCourses(keypass)
    }
}