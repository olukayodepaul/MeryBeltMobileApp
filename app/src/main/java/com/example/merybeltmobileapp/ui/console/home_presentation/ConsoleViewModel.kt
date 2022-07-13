package com.example.merybeltmobileapp.ui.console.home_presentation

import androidx.compose.ui.geometry.Size
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.merybeltmobileapp.Application
import com.example.merybeltmobileapp.provider.api.api_provider_domain.MerryBeltApiRepository
import com.example.merybeltmobileapp.ui.console.home_data.ConsoleEvent
import com.example.merybeltmobileapp.ui.console.home_data.ConsoleState
import com.example.merybeltmobileapp.ui.console.home_data.console_dto.Banks
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

    //Update state change
    private fun setCustomerId(customerId: String, balance:String) {
        uiState.value = uiState.value.copy(
            customerId = customerId,
            balance = balance
        )
    }

    private fun setBankList(bankList: List<Banks.BankList>) {
        uiState.value = uiState.value.copy(
            banklist = bankList,
        )
    }

    //Setting all the expandable values
    private fun onEnable(enable: Boolean){
        uiState.value = uiState.value.copy(
            enable = enable
        )
    }

    private fun onValue(value: String){
        uiState.value = uiState.value.copy(
            value = value
        )
    }

    private fun onSelectedItemIndex(selectedItemIndex: Int){
        uiState.value = uiState.value.copy(
            selectedItemIndex = selectedItemIndex,
        )
    }

    private fun onSize (size: Size){
        uiState.value = uiState.value.copy(
            size = size
        )
    }

    private fun onBankLogo (bankLogo: String){
        uiState.value = uiState.value.copy(
            bankLogo = bankLogo
        )
    }


    private fun getBankList(){
        viewModelScope.launch {
            try {
                val isBankList = repo.getBankList(terminalId = "", sessionId = "")
                setBankList(isBankList.body()!!.data)
            }catch (e: Throwable){
            }
        }
    }


    //event
    fun consoleEventHandler(consoleEvent: ConsoleEvent) {
        when(consoleEvent){
            is ConsoleEvent.onEnable->{
                onEnable(consoleEvent.enable)
            }
            is ConsoleEvent.onValue->{
                onValue(consoleEvent.value)
            }
            is ConsoleEvent.onSelectedItemIndex->{
                onSelectedItemIndex(consoleEvent.selectedItemIndex)
            }
            is ConsoleEvent.onSize->{
                onSize(consoleEvent.size)
            }

            is ConsoleEvent.onBankLog->{
                onBankLogo(consoleEvent.bankLogo)
            }
        }
    }

    init {
        viewModelScope.launch {
            getBankList()
            setCustomerId(
                customerId = repo.loadUserInfo().customerId,
                balance = repo.loadUserInfo().balance
            )
        }
    }

}