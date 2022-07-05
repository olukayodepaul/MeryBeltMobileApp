package com.example.merybeltmobileapp.ui.login.login_presentation

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.merybeltmobileapp.Application
import com.example.merybeltmobileapp.provider.api.api_provider_domain.MerryBeltApiRepository
import com.example.merybeltmobileapp.ui.login.login_data.login_dto.LoginResponse
import com.example.merybeltmobileapp.util.NetworkResult
import com.example.merybeltmobileapp.util.getHash
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repo: MerryBeltApiRepository,
    private val app: Application,
): ViewModel() {

    val userName = mutableStateOf("")
    val userPassword = mutableStateOf("")

    fun onChangeUserName(userName:String ){
        this.userName.value = userName
    }

    fun onChangeUserPassword(userPassword:String ){
        this.userPassword.value = userPassword
    }

    private val _uiFlow = MutableStateFlow<NetworkResult<LoginResponse>>(NetworkResult.Empty)
    val uiFlow get() = _uiFlow

    fun onEvent(event: TrackerOverviewEvent) {
        when(event){
            is TrackerOverviewEvent.OnClick->{

                viewModelScope.launch {
                    try{
                        val requestTime = SimpleDateFormat("yyyyMMddHHmmssZ").format(Date())
                        val apiHashKey = getHash("${repo.apiUser()}${repo.token()}$requestTime")
                        val apiUser = 8
                        val res = repo.login(requestTime, apiHashKey, apiUser, event.login)

                        if(res.isSuccessful && res.code() == 200) {

                            repo.saveShopName(res.body()!!.shopName)
                            repo.saveShopAddress(res.body()!!.shopAddress)
                            //

                        }else{
                            Toast.makeText(app, "${res.body()!!.response.data}", Toast.LENGTH_SHORT).show()
                        }

                    }catch (e: Throwable) {
                        Toast.makeText(app, "${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}