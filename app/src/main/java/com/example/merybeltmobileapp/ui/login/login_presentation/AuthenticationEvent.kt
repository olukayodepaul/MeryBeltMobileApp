package com.example.merybeltmobileapp.ui.login.login_presentation

sealed class AuthenticationEvent {
    object ToggleAuthenticationMode: AuthenticationEvent()
    class EmailChanged(val emailAddress: String): AuthenticationEvent()
    class PasswordChanged(val password: String): AuthenticationEvent()
    class CheckRemote(val emailAddress: String, val password: String): AuthenticationEvent()
    object Authenticate: AuthenticationEvent()
    object ErrorDismissed: AuthenticationEvent()
}

