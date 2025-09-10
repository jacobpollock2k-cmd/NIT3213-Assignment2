package com.android.example.assignment2.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.example.assignment2.models.CourseList
import com.android.example.assignment2.network.ApiRepository
import com.android.example.assignment2.models.KeyPass
import com.android.example.assignment2.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ApiViewModel() : ViewModel() {
    private val repository = ApiRepository()
    val testKeyPass = KeyPass("123")
    val testKeyPass2 = CourseList(listOf(), 0)

    private val mutableObjectState = MutableStateFlow<KeyPass>(testKeyPass)
    val objectState: StateFlow<KeyPass> = mutableObjectState

    private val mutableObjectState2 = MutableStateFlow<CourseList>(testKeyPass2)
    val objectState2: StateFlow<CourseList> = mutableObjectState2

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

    fun getCourses() {
        viewModelScope.launch {
            val testKeyPass = KeyPass("courses")
            try {
                val objects = repository.getCourses(testKeyPass)
                mutableObjectState2.value = objects
            } catch (e: Exception) {
                _errorState.value = "Error"
            }
        }

    }

}