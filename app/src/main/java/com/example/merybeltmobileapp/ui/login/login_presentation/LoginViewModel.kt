package com.example.merybeltmobileapp.ui.login.login_presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.merybeltmobileapp.Application
import com.example.merybeltmobileapp.R
import com.example.merybeltmobileapp.provider.api.api_provider_domain.MerryBeltApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repo: MerryBeltApiRepository,
    private val app: Application
): ViewModel() {

    init {

        viewModelScope.launch {

            Log.d("EPOKHAI","${repo.token()} , " +
                    "${repo.apiUser()}" +
                    " ${app.getString(R.string.app_name)}" +
                    "")
        }
    }

}