package com.android.example.assignment2.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
data class KeyPass(
    @Json(name="keypass") val keypass: String
): Parcelable