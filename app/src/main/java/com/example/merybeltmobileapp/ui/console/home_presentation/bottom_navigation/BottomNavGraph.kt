package com.example.merybeltmobileapp.ui.console.home_presentation.bottom_navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.merybeltmobileapp.ui.console.home_presentation.ConsoleViewModel
import com.example.merybeltmobileapp.ui.console.home_presentation.screen.BillPaymentScreen
import com.example.merybeltmobileapp.ui.console.home_presentation.screen.HomeScreen
import com.example.merybeltmobileapp.ui.console.home_presentation.screen.TransactionScreen


@Composable
fun BottomNavGraph(
    viewModel: ConsoleViewModel = hiltViewModel(),
    navController: NavHostController,
    localContext: Context
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(
                navController = navController,
                localContext = localContext,
                viewModel = viewModel,
                consoleEventHandler = viewModel::consoleEventHandler
            )
        }
        composable(route = BottomBarScreen.BillPayment.route) {
            BillPaymentScreen(

            )
        }
        composable(route = BottomBarScreen.Transaction.route) {
            TransactionScreen(

            )
        }
    }
}