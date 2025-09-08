package com.android.example.assignment2.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Entity(
    @Json(name = "entities")var entities: MutableList<Courses>,
    @Json(name = "entityTotal") val entityTotal: Int
)

@JsonClass(generateAdapter = true)
data class Courses (
    @Json(name = "courseCode") val courseCode: String,
    @Json(name = "courseName")val courseName: String,
    @Json(name = "instructor")val courseInstructor: String,
    @Json(name = "credits")val courseCredits: Int,
    @Json(name = "description")val courseDescription: String
)
