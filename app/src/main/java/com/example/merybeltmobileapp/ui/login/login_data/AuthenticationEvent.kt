package com.example.merybeltmobileapp.ui.login.login_data

sealed class AuthenticationEvent {
    class ChangeUserName(val username: String): AuthenticationEvent()
    class ChangeUserPassword(val passwords: String): AuthenticationEvent()
    class ChangeUserProgressBar(val loader: Boolean): AuthenticationEvent()
    class ShowUserDialog(val message: String? = "", val viewStatus: Boolean? = false): AuthenticationEvent()
}