package com.android.example.assignment2.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class User(
    @Json(name="password") val password: String?,
    @Json(name="username") val username: String?
)
