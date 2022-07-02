package com.example.merybeltmobileapp.ui.login.login_presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.merybeltmobileapp.provider.api.api_provider_domain.MerryBeltApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val merryBeltRepository: MerryBeltApiRepository
): ViewModel() {

    init {
        viewModelScope.launch {
            Log.d("EPOKHAI","${merryBeltRepository.token()} , ${merryBeltRepository.apiUser()}")
        }
    }

}