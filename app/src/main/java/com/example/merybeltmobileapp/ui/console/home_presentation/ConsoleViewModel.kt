package com.example.merybeltmobileapp.ui.console.home_presentation

import android.widget.Toast
import androidx.compose.ui.geometry.Size
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.merybeltmobileapp.Application
import com.example.merybeltmobileapp.provider.api.api_provider_domain.MerryBeltApiRepository
import com.example.merybeltmobileapp.ui.console.home_data.ConsoleEvent
import com.example.merybeltmobileapp.ui.console.home_data.ConsoleState
import com.example.merybeltmobileapp.ui.console.home_data.console_dto.Banks
import com.example.merybeltmobileapp.ui.console.home_data.console_dto.NetworkMgtReq
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
    private fun setCustomerId(customerId: String, balance: String) {
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
    private fun onEnable(enable: Boolean) {
        uiState.value = uiState.value.copy(enable = enable)
    }

    private fun onValue(value: String) {

        if (value.isNotEmpty() && uiState.value.accNumber.length == 10) {
            uiState.value = uiState.value.copy(enableWidget = true)
        } else {
            uiState.value = uiState.value.copy(enableWidget = false)
        }
        uiState.value = uiState.value.copy(value = value)
    }

    private fun onSelectedItemIndex(selectedItemIndex: Int) {
        uiState.value = uiState.value.copy(selectedItemIndex = selectedItemIndex,)
    }

    private fun onSize(size: Size) {
        uiState.value = uiState.value.copy(size = size)
    }

    private fun onBankLogo(bankLogo: String) {
        uiState.value = uiState.value.copy(bankLogo = bankLogo)
    }

    private fun onAccountNumber(accNumber: String) {

        if (uiState.value.value.isNotEmpty() && accNumber.length == 10) {
            uiState.value = uiState.value.copy(
                enableWidget = true
            )
            //Toast.makeText(appContext, "${accNumber.length} $accNumber", Toast.LENGTH_LONG).show()
        } else {
            uiState.value = uiState.value.copy(
                enableWidget = false
            )
        }

        uiState.value = uiState.value.copy(
            accNumber = accNumber
        )
    }

    private fun onAccountName(accName: String) {
        uiState.value = uiState.value.copy(
            accName = accName
        )
    }

    private fun onAccAmount(accAmount: String) {
        uiState.value = uiState.value.copy(
            accAmount = accAmount
        )
    }

    private fun onAccRemark(accRemark: String) {
        uiState.value = uiState.value.copy(
            accRemark = accRemark
        )
    }

    private fun getBankList() {
        viewModelScope.launch {
            try {
                val isBankList = repo.getBankList(terminalId = "", sessionId = "")
                setBankList(isBankList.body()!!.data)
            } catch (e: Throwable) {
            }
        }
    }

    //event
    fun consoleEventHandler(consoleEvent: ConsoleEvent) {
        when (consoleEvent) {
            is ConsoleEvent.onEnable -> {
                onEnable(consoleEvent.enable)
            }
            is ConsoleEvent.onValue -> {
                onValue(consoleEvent.value)
            }
            is ConsoleEvent.onSelectedItemIndex -> {
                onSelectedItemIndex(consoleEvent.selectedItemIndex)
            }
            is ConsoleEvent.onSize -> {
                onSize(consoleEvent.size)
            }

            is ConsoleEvent.onBankLog -> {
                onBankLogo(consoleEvent.bankLogo)
            }

            is ConsoleEvent.onAccountNumber -> {
                onAccountNumber(consoleEvent.accNumber)
            }

            is ConsoleEvent.onAccountName -> {
                onAccountName(consoleEvent.accName)
            }

            is ConsoleEvent.onAmount -> {
                onAccAmount(consoleEvent.accAmount)
            }

            is ConsoleEvent.onRemark -> {
                onAccRemark(consoleEvent.accRemark)
            }
        }
    }

    init {
        viewModelScope.launch {

            try{

                val bodyData  = NetworkMgtReq(
                    serialNumber = "63201125995137",
                    stan = "123456",
                    onlyAccountInfo = false
                )

                val isTestResponse = repo.networkMgt(bodyData)
                Toast.makeText(appContext, "1 " +isTestResponse.body()!!.data!!.sessionId, Toast.LENGTH_LONG).show()

            }catch (err:Throwable){

                Toast.makeText(appContext, "2 " +err.message.toString(), Toast.LENGTH_LONG).show()

            }


//            getBankList()
//            setCustomerId(
//                customerId = repo.loadUserInfo().customerId,
//                balance = repo.loadUserInfo().balance
//            )
        }
    }

}