package com.example.merybeltmobileapp.ui.login.login_data

import com.example.merybeltmobileapp.ui.login.login_data.login_dto.dialogMapper

sealed class AuthenticationEvent {
    class ChangeUserName(val username: String): AuthenticationEvent()
    class ChangeUserPassword(val passwords: String): AuthenticationEvent()
    class ChangeUserProgressBar(val loadingProgressBar: Boolean): AuthenticationEvent()
    class ShowUserDialog(
        val isDialogTitle: String,
        val isDialogMessage: String,
        val isDialogShow: Boolean
    ): AuthenticationEvent()
    object apiNetwork : AuthenticationEvent()

}