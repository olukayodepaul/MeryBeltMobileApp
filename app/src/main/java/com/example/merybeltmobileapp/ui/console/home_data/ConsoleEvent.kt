package com.example.merybeltmobileapp.ui.console.home_data

import androidx.compose.ui.geometry.Size


sealed class ConsoleEvent{
    class onEnable(val enable: Boolean): ConsoleEvent()
    class onValue(val value: String): ConsoleEvent()
    class onSelectedItemIndex(val selectedItemIndex: Int): ConsoleEvent()
    //class onIcon(val icon: Int): ConsoleEvent()
    class onSize(val size: Size): ConsoleEvent()
    class onBankLog(val bankLogo: String): ConsoleEvent()
    class  onAccountNumber(val accNumber: String) : ConsoleEvent()
    class  onAccountName(val accName: String) : ConsoleEvent()
    class onAmount(val accAmount: String) : ConsoleEvent()
    class onRemark(val accRemark: String) : ConsoleEvent()
}

