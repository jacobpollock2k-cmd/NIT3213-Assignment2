package com.android.example.assignment2.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Course(
    @Json(name="courseCode") val courseCode: String,
    @Json(name="courseName") val courseName: String,
    @Json(name="credits") val credits: Int,
    @Json(name="description") val description: String,
    @Json(name="instructor") val instructor: String
): Parcelable