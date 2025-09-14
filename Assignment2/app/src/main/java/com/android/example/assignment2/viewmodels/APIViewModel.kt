package com.android.example.assignment2.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.example.assignment2.models.CourseList
import com.android.example.assignment2.network.ApiRepository
import com.android.example.assignment2.models.KeyPass
import com.android.example.assignment2.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApiViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {
    //private val repository = ApiRepository()
    val testKeyPass = KeyPass("")
    val testKeyPass2 = CourseList(listOf(), 0)

    private val mutableObjectState = MutableStateFlow<KeyPass>(testKeyPass)
    val objectState: StateFlow<KeyPass> = mutableObjectState

    private val mutableObjectState2 = MutableStateFlow<CourseList>(testKeyPass2)
    val objectState2: StateFlow<CourseList> = mutableObjectState2

    private val _errorState = MutableStateFlow<String?>(null)
    val errorState: StateFlow<String?> = _errorState

    fun authoriseUser(user: User){
        viewModelScope.launch {

            try {

                val objects = repository.authoriseUser(user)
                mutableObjectState.value= objects
            } catch (e: Exception){
                _errorState.value = "Error"
            }
        }
    }

    fun getCourses(keypass : String) {
        viewModelScope.launch {
            try {
                val objects = repository.getCourses(keypass)
                mutableObjectState2.value = objects
            } catch (e: Exception) {
                _errorState.value = "Error"
            }
        }

    }

}