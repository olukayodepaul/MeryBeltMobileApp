package com.example.merybeltmobileapp.ui.login.login_presentation


import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.merybeltmobileapp.Application
import com.example.merybeltmobileapp.provider.api.api_provider_domain.MerryBeltApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.viewModelScope
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationEvent
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationMode
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationState
import com.example.merybeltmobileapp.ui.login.login_data.PasswordRequirements
import com.example.merybeltmobileapp.ui.login.login_data.login_dto.LoginCredential
import com.example.merybeltmobileapp.util.getHash
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val repo: MerryBeltApiRepository,
    private val appContext: Application,
): ViewModel() {

    var uiState = MutableStateFlow(AuthenticationState())

    //this is event to change the screen state
    private fun toggleAuthenticationMode() {

        val authenticationMode = uiState.value.authenticationMode
        val newAuthenticationMode = if (
            authenticationMode == AuthenticationMode.SIGN_IN
        ) {
            AuthenticationMode.SIGN_UP
        } else {
            AuthenticationMode.SIGN_IN
        }
        uiState.value = uiState.value.copy(
            authenticationMode = newAuthenticationMode
        )
    }

    //This is the event to change enail state
    private fun updateEmail(email: String) {
        uiState.value = uiState.value.copy(
            email = email
        )
    }

    //this is the event to change password state
    private fun updatePassword(password: String) {
        val requirements = mutableListOf<PasswordRequirements>()
        if (password.length > 7) {
            requirements.add(PasswordRequirements.EIGHT_CHARACTERS)
        }
        if (password.any { it.isUpperCase() }) {
            requirements.add(PasswordRequirements.CAPITAL_LETTER)
        }
        if (password.any { it.isDigit() }) {
            requirements.add(PasswordRequirements.NUMBER)
        }
        uiState.value = uiState.value.copy(
            password = password,
            //passwordRequirements = requirements.toList()
        )
    }

    private fun remoteEvent(email: String, password: String) {
       // updateEmail("bcjsjsanjnsdjnsnajn")
        viewModelScope.launch {
            try{
                val requestTime = SimpleDateFormat("yyyyMMddHHmmssZ").format(Date())
                val apiHashKey = getHash("${repo.apiUser()}${repo.token()}$requestTime")
                val data = LoginCredential(login = email,loginPasswordMD5 = password)

                val loginApi = repo.login(
                    requestTime = requestTime,
                    apiHashKey = apiHashKey,
                    apiUserId = 8,
                    data = data
                )

                if(loginApi.code()==200 || loginApi.isSuccessful){
                    Toast.makeText(appContext, "${loginApi.body()}", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(appContext, "${loginApi.body()}", Toast.LENGTH_LONG).show()
                }

            }catch (e: Throwable) {
                Toast.makeText(appContext, "${e.message}", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun dismissError() {
        uiState.value = uiState.value.copy(
            error = null
        )
    }

    private fun authenticate() {
        uiState.value = uiState.value.copy(
            isLoading = true
        )
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000L)

            withContext(Dispatchers.Main) {
                uiState.value = uiState.value.copy(
                    isLoading = false,
                    error = "Something went wrong!"
                )
            }
        }
    }

    //This is function to handle toggleAuthenticationMode() outside the the viewModel
    fun handleEvent(authenticationEvent: AuthenticationEvent) {
        when (authenticationEvent) {
            is AuthenticationEvent.ToggleAuthenticationMode -> {
                toggleAuthenticationMode()
            }
            is AuthenticationEvent.EmailChanged->{
                updateEmail(authenticationEvent.emailAddress)
            }
            is AuthenticationEvent.PasswordChanged->{
                updatePassword(authenticationEvent.password)
            }
            is AuthenticationEvent.Authenticate->{
                authenticate()
            }
            is AuthenticationEvent.ErrorDismissed -> {
                dismissError()
            }
            is AuthenticationEvent.CheckRemote->{
                remoteEvent(authenticationEvent.emailAddress, authenticationEvent.password)
            }
        }
    }

}
