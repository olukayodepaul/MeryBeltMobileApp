package com.example.merybeltmobileapp.ui.login.login_presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.merybeltmobileapp.Application
import com.example.merybeltmobileapp.provider.api.api_provider_domain.MerryBeltApiRepository
import com.example.merybeltmobileapp.ui.login.login_data.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationEvent
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val repo: MerryBeltApiRepository,
    private val appContext: Application,
) : ViewModel() {

    private val _apiEvent = Channel<ApiState>()
    val uiEvent = _apiEvent.receiveAsFlow()

    var uiState = MutableStateFlow(AuthenticationState())

    private fun updateUsernameEvent(username: String) {
        uiState.value = uiState.value.copy(
            username = username
        )
    }

    private fun showUserDialogEvent(isDialogMessage: String, isDialogShow: Boolean) {
        uiState.value = uiState.value.copy(
            isDialogMessage = isDialogMessage,
            isDialogShow = isDialogShow,
        )
    }

    private fun updatePasswordEvent(password: String) {
        uiState.value = uiState.value.copy(
            password = password
        )
    }

    private fun updateProgressBarEvent(loader: Boolean) {
        uiState.value = uiState.value.copy(
            loadingProgressBar = loader
        )
    }

    fun AuthApiRequest(
        userName: String,
        password: String
    ) {

        viewModelScope.launch {
            _apiEvent.send(
                ApiState.Success(
                    "This is paul"
                )
            )
        }
        //mutableState.value = ApiState.Error(e)

//        try {
//
//        } catch (e: Throwable) {
//
//        }

    }


    fun eventHandler(authenticationEvent: AuthenticationEvent) {
        when (authenticationEvent) {
            is AuthenticationEvent.ChangeUserName -> {
                updateUsernameEvent(authenticationEvent.username)
            }
            is AuthenticationEvent.ChangeUserPassword -> {
                updatePasswordEvent(authenticationEvent.passwords)
            }
            is AuthenticationEvent.ChangeUserProgressBar -> {
                updateProgressBarEvent(authenticationEvent.loadingProgressBar)
            }
            is AuthenticationEvent.ShowUserDialog -> {
                showUserDialogEvent(
                    authenticationEvent.isDialogMessage!!,
                    authenticationEvent.isDialogShow!!
                )
            }
        }
    }

}
