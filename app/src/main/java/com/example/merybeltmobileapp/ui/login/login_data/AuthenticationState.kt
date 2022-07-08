package com.example.merybeltmobileapp.ui.login.login_data



data class AuthenticationState(
    val username: String = "",
    val password: String = "",
    val loadingProgressBar: Boolean = false,
    val isDialog: Boolean = false

)

