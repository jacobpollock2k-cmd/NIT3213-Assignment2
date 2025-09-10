package com.android.example.assignment2.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class KeyPass(
    @Json(name="keypass") val keypass: String
)