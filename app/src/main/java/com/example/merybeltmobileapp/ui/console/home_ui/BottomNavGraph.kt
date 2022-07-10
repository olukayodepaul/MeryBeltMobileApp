package com.example.merybeltmobileapp.ui.console.home_ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.merybeltmobileapp.ui.console.home_ui.screen.BillPaymentScreen
import com.example.merybeltmobileapp.ui.console.home_ui.screen.HomeScreen
import com.example.merybeltmobileapp.ui.console.home_ui.screen.TransactionScreen


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.BillPayment.route) {
            BillPaymentScreen()
        }
        composable(route = BottomBarScreen.Transaction.route) {
            TransactionScreen()
        }
    }
}