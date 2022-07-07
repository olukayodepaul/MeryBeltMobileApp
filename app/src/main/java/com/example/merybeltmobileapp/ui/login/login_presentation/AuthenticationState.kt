package com.example.merybeltmobileapp.ui.login.login_presentation

import java.util.*

data class AuthenticationState(
    val authenticationMode: AuthenticationMode = AuthenticationMode.SIGN_IN,
    val email: String = "",
    val password: String = "",
    val passwordRequirements: List<Arrays> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
