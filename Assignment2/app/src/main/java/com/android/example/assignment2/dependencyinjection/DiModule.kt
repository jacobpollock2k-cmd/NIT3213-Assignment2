package com.android.example.assignment2.dependencyinjection

import com.android.example.assignment2.network.ApiService
import com.android.example.assignment2.network.RetroFitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DiModule {

    @Provides
    fun provideApiClient(): ApiService{return RetroFitClient().apiService}

}