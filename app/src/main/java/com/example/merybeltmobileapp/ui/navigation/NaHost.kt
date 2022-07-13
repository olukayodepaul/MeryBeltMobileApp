package com.example.merybeltmobileapp.ui.navigation

sealed class NaHost(val route: String){
    object MainScreen: NaHost(route = "main_screen")
    object HomeScreen: NaHost(route = "home_screen")
    object CreditScreen: NaHost(route = "credit_route")
    object WithdrawScreen: NaHost(route = "withdraw_route")
    object TransferScreen: NaHost(route = "transfer_route")
    object BillScreen: NaHost(route = "bill_route")
}
