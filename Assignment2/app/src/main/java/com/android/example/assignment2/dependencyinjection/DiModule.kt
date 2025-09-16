package com.android.example.assignment2.dependencyinjection

import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.android.example.assignment2.models.Course
import com.android.example.assignment2.network.ApiService
import com.android.example.assignment2.network.RetroFitClient
import com.android.example.assignment2.recycleview.MyAdapter
import com.android.example.assignment2.viewmodels.ApiViewModel
import com.android.example.assignment2.views.DashboardFragment
import com.android.example.assignment2.views.DashboardFragmentDirections
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.currentCoroutineContext


@Module
@InstallIn(SingletonComponent::class)
object DiModule {

    @Provides
    fun provideApiClient(): ApiService {
        return RetroFitClient().apiService
    }


 }