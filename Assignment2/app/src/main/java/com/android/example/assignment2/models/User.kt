package com.android.example.assignment2.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    @Json(name="userName")val userName: String,
    @Json(name="password")val password: String
)
