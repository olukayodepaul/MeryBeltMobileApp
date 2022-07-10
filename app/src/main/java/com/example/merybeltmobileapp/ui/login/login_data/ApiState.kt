package com.example.merybeltmobileapp.ui.login.login_data

sealed class ApiState {
    object Loading : ApiState()
    data class Success(val album: String) : ApiState()
    data class Error(val error: Throwable) : ApiState()

}