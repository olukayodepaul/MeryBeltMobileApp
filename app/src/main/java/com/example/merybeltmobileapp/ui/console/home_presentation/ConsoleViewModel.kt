package com.example.merybeltmobileapp.ui.console.home_presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.merybeltmobileapp.Application
import com.example.merybeltmobileapp.provider.api.api_provider_domain.MerryBeltApiRepository
import com.example.merybeltmobileapp.ui.console.home_data.ConsoleEvent
import com.example.merybeltmobileapp.ui.console.home_data.ConsoleState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConsoleViewModel @Inject constructor(
    private val repo: MerryBeltApiRepository,
    private val appContext: Application,
) : ViewModel() {

    //state
    var uiState = MutableStateFlow(ConsoleState())

    //state event
    private fun setCustomerId(customerId: String, balance:String) {
        uiState.value = uiState.value.copy(
            customerId = customerId,
            balance = balance
        )
    }


    //event
    fun consoleEventHandler(consoleEvent: ConsoleEvent) {

    }

    init {
        viewModelScope.launch {
            setCustomerId(
                customerId = repo.loadUserInfo().customerId,
                balance = repo.loadUserInfo().balance
            )
        }
    }

}