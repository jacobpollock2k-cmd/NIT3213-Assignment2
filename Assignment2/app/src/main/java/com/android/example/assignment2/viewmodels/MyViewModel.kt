package com.android.example.assignment2.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyViewModel : ViewModel() {

    private val _stateFlow = MutableStateFlow("Value")
    val stateFlow: StateFlow<String> = _stateFlow

    fun getDetails(username:String,  password: String){

    }
}