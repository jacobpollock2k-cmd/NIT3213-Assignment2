package com.android.example.assignment2.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.example.assignment2.network.ApiRepository
import com.android.example.assignment2.models.KeyPass
import com.android.example.assignment2.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ApiViewModel() : ViewModel() {
    private val repository = ApiRepository()
    val testKeyPass = KeyPass("123")

    private val mutableObjectState = MutableStateFlow<KeyPass>(testKeyPass)
    val objectState: StateFlow<KeyPass> = mutableObjectState

    private val _errorState = MutableStateFlow<String?>(null)
    val errorState: StateFlow<String?> = _errorState

    fun authoriseUser(user: User){
        viewModelScope.launch {
            val testUser : User = User("8090760", username = "Jacob")
            try {

                val objects = repository.authoriseUser(user)
                mutableObjectState.value= objects
            } catch (e: Exception){
                _errorState.value = "Error"
            }
        }
    }

}