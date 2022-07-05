package com.example.merybeltmobileapp.ui.login.login_presentation

import com.example.merybeltmobileapp.ui.login.login_data.login_dto.LoginCredential


sealed class TrackerOverviewEvent {
    data class OnClick(val login: LoginCredential): TrackerOverviewEvent()
}

