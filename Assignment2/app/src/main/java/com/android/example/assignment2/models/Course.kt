package com.android.example.assignment2.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Course(
    @Json(name="courseCode") val courseCode: String,
    @Json(name="courseName") val courseName: String,
    @Json(name="credits") val credits: Int,
    @Json(name="description") val description: String,
    @Json(name="instructor") val instructor: String
)