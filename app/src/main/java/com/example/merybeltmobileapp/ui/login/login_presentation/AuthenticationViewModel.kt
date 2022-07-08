package com.example.merybeltmobileapp.ui.login.login_presentation


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.merybeltmobileapp.Application
import com.example.merybeltmobileapp.provider.api.api_provider_domain.MerryBeltApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationEvent
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val repo: MerryBeltApiRepository,
    private val appContext: Application,
): ViewModel() {

    var uiState = MutableStateFlow(AuthenticationState())

    private fun updateUsernameEvent(username: String) {
        uiState.value = uiState.value.copy(
            username = username
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

    private fun showUserDialogEvent(isDialogTitle: String, isDialogMessage: String, isDialogShow: Boolean) {
        uiState.value = uiState.value.copy(
            isDialogMessage = isDialogMessage,
            isDialogShow = isDialogShow
        )
    }

    private fun apiNetworkCall() {
        viewModelScope.launch {

            val userName = uiState.value.username
            val password = uiState.value.password

            if(userName.isEmpty() && password.isEmpty()) {
                uiState.value = uiState.value.copy(
                    isDialogMessage = "Please enter correct username and password!",
                    isDialogShow = true
                )
            }else{
                //Make a network Call from here
            }
        }
    }

    fun eventHandler(authenticationEvent: AuthenticationEvent) {
        when (authenticationEvent) {
            is AuthenticationEvent.ChangeUserName->{
                updateUsernameEvent(authenticationEvent.username)
            }
            is AuthenticationEvent.ChangeUserPassword->{
                updatePasswordEvent(authenticationEvent.passwords)
            }
            is AuthenticationEvent.ChangeUserProgressBar->{
                updateProgressBarEvent(authenticationEvent.loadingProgressBar)
            }
            is AuthenticationEvent.ShowUserDialog->{
                showUserDialogEvent(authenticationEvent.isDialogTitle, authenticationEvent.isDialogMessage, authenticationEvent.isDialogShow)
            }
            is AuthenticationEvent.apiNetwork->{
                apiNetworkCall()
            }
        }
    }

}


//
//
//    //this is event to change the screen state
//    private fun toggleAuthenticationMode() {
//
//        val authenticationMode = uiState.value.authenticationMode
//        val newAuthenticationMode = if (
//            authenticationMode == AuthenticationMode.SIGN_IN
//        ) {
//            AuthenticationMode.SIGN_UP
//        } else {
//            AuthenticationMode.SIGN_IN
//        }
//        uiState.value = uiState.value.copy(
//            authenticationMode = newAuthenticationMode
//        )
//    }
//
//    //This is the event to change enail state
//    private fun updateEmail(email: String) {
//        uiState.value = uiState.value.copy(
//            email = email
//        )
//    }
//
//    //this is the event to change password state
//    private fun updatePassword(password: String) {
//        val requirements = mutableListOf<PasswordRequirements>()
//        if (password.length > 7) {
//            requirements.add(PasswordRequirements.EIGHT_CHARACTERS)
//        }
//        if (password.any { it.isUpperCase() }) {
//            requirements.add(PasswordRequirements.CAPITAL_LETTER)
//        }
//        if (password.any { it.isDigit() }) {
//            requirements.add(PasswordRequirements.NUMBER)
//        }
//        uiState.value = uiState.value.copy(
//            password = password,
//            //passwordRequirements = requirements.toList()
//        )
//    }
//
//    private fun remoteEvent() {
//
//        viewModelScope.launch {
//            try{
//
//                val userName = uiState.value.email
//                val password = uiState.value.password
//
//                Log.d("EPOKHAI", "$userName $password")
//
//                val requestTime = SimpleDateFormat("yyyyMMddHHmmssZ").format(Date())
//                val apiHashKey = getHash("${repo.apiUser()}${repo.token()}$requestTime")
//                val data = LoginCredential(login = userName,loginPasswordMD5 = password)
//
//                val loginApi = repo.login(
//                    requestTime = requestTime,
//                    apiHashKey = apiHashKey,
//                    apiUserId = 8,
//                    data = data
//                )
//
//                if(loginApi.code()==200 || loginApi.isSuccessful){
//                    Toast.makeText(appContext, "${loginApi.body()}", Toast.LENGTH_LONG).show()
//                }else{
//                    Toast.makeText(appContext, "${loginApi.body()}", Toast.LENGTH_LONG).show()
//                }
//
//            }catch (e: Throwable) {
//                Toast.makeText(appContext, "${e.message}", Toast.LENGTH_LONG).show()
//            }
//        }
//
//    }
//
//    private fun dismissError(dismissed:Boolean) {
//        Log.d("EPOKHA","E5 $dismissed")
//        uiState.value = uiState.value.copy(
//            error = dismissed
//        )
//    }
//
//    private fun authenticate() {
//        uiState.value = uiState.value.copy(
//            isLoading = true
//        )
//    }
//
//    //This is function to handle toggleAuthenticationMode() outside the the viewModel
//    fun handleEvent(authenticationEvent: AuthenticationEvent) {
//        when (authenticationEvent) {
//            is AuthenticationEvent.ToggleAuthenticationMode -> {
//                toggleAuthenticationMode()
//            }
//            is AuthenticationEvent.EmailChanged->{
//                updateEmail(authenticationEvent.emailAddress)
//            }
//            is AuthenticationEvent.PasswordChanged->{
//                updatePassword(authenticationEvent.password)
//            }
//            is AuthenticationEvent.Authenticate->{
//                authenticate()
//            }
//            is AuthenticationEvent.ErrorDismissed -> {
//                dismissError(authenticationEvent.dismissed)
//            }
//            is AuthenticationEvent.CheckRemote->{
//                remoteEvent()
//            }
//        }
//    }
//
//    //state and event for dialog
//    private val _showDialog = MutableStateFlow(false)
//    val showDialog: StateFlow<Boolean> = _showDialog.asStateFlow()
//
//    fun onOpenDialogClicked() {
//        _showDialog.value = true
//    }
//
//    fun onDialogConfirm(dialog: Boolean) {
//        _showDialog.value = dialog
//        // Continue with executing the confirmed action
//    }


//}
