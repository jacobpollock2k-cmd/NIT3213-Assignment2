package com.android.example.assignment2.dependencyinjection

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyBaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}