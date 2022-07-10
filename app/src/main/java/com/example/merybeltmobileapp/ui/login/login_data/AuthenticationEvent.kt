package com.example.merybeltmobileapp.ui.login.login_data

sealed class AuthenticationEvent {
    class ChangeUserName(val username: String): AuthenticationEvent()
    class ChangeUserPassword(val passwords: String): AuthenticationEvent()
    class ChangeUserProgressBar(val loadingProgressBar: Boolean): AuthenticationEvent()
    class ShowUserDialog(val isDialogMessage: String? = "", val isDialogShow: Boolean? = false): AuthenticationEvent()
    //object apiNetwork : AuthenticationEvent()
}