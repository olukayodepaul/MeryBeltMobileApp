package com.example.merybeltmobileapp.ui.login.login_presentation

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.merybeltmobileapp.Application
import com.example.merybeltmobileapp.provider.api.api_provider_domain.MerryBeltApiRepository
import com.example.merybeltmobileapp.ui.login.login_data.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationEvent
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationState
import com.example.merybeltmobileapp.ui.login.login_data.login_dto.LoginCredential
import com.example.merybeltmobileapp.util.getHash
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

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

    @SuppressLint("SimpleDateFormat")
    fun AuthApiRequest(
        userName: String,
        password: String
    ) {

        viewModelScope.launch {

            val _userName = userName
            val _password = password

            if (_userName.isEmpty() || _password.isEmpty()) {
                showUserDialogEvent(
                    isDialogMessage = "Please enter correct username and password!",
                    isDialogShow = true,
                )
            } else {

                updateProgressBarEvent(loader = true)

                try {

                    val requestTime = SimpleDateFormat("yyyyMMddHHmmssZ").format(Date())
                    val apiHashKey = getHash("${repo.apiUser()}${repo.token()}$requestTime")
                    val apiUser = repo.apiID()

                    val bodyRequest = LoginCredential(_userName, _password)
                    val handleApiRequest = repo.login(requestTime, apiHashKey, apiUser, bodyRequest)

                    val bodyPayLoad = handleApiRequest.body()

                    if(bodyPayLoad!!.errorStatusCode==1){

                        repo.saveShopAddress(bodyPayLoad.shopAddress!!)
                        repo.saveShopName(bodyPayLoad.shopName!!)
                        repo.saveBalance(bodyPayLoad.balance!!.balance!!)
                        repo.saveCustomerId(bodyPayLoad.customerId!!)

                        _apiEvent.send(
                            ApiState.Success(
                                status = 200
                            )
                        )

                    }else{
                        _apiEvent.send(
                            ApiState.Error(
                                error =  bodyPayLoad.shopName!!,
                            )
                        )
                    }

                }catch (e:Throwable) {
                    _apiEvent.send(
                        ApiState.Error(
                            error =  e.message.toString(),
                        )
                    )
                }
            }
        }
    }


    fun authEventHandler(authenticationEvent: AuthenticationEvent) {
        when (authenticationEvent) {
            is AuthenticationEvent.ChangeUserName -> {
                updateUsernameEvent(authenticationEvent.username)
            }
            is AuthenticationEvent.ChangeUserPassword -> {
                updatePasswordEvent(authenticationEvent.passwords)
            }
            is AuthenticationEvent.ChangeUserProgressBar -> {
                updateProgressBarEvent(authenticationEvent.loader)
            }
            is AuthenticationEvent.ShowUserDialog -> {
                showUserDialogEvent(
                    authenticationEvent.message!!,
                    authenticationEvent.viewStatus!!
                )
            }
        }
    }

}
