package com.android.example.assignment2.network

import com.android.example.assignment2.models.CourseList
import com.android.example.assignment2.models.KeyPass
import com.android.example.assignment2.models.User

class ApiRepository(private val apiService: ApiService = RetroFitClient().apiService) {
    suspend fun authoriseUser(newObject: User) : KeyPass {
        return apiService.authoriseUser(newObject)
    }

    suspend fun getCourses(keypass: KeyPass): CourseList {
        return apiService.getCourses(keypass)
    }
}