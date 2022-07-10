package com.example.merybeltmobileapp.ui.login.login_data

sealed class ApiState {
    object Loading : ApiState()
    data class Success(val status: Int) : ApiState()
    data class Error(val error: String) : ApiState()

}