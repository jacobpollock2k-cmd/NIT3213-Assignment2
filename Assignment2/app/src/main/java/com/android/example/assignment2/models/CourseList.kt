package com.android.example.assignment2.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CourseList(
    @Json(name="entities") val entities: List<Course>,
    @Json(name="entityTotal") val entityTotal: Int
)