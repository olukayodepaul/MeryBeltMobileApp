package com.example.merybeltmobileapp.ui.console.home_presentation.bottom_navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.merybeltmobileapp.ui.console.home_data.ConsoleEvent
import com.example.merybeltmobileapp.ui.console.home_data.ConsoleState
import com.example.merybeltmobileapp.ui.console.home_presentation.ConsoleViewModel
import com.example.merybeltmobileapp.ui.console.home_presentation.TransferFunds
import com.example.merybeltmobileapp.ui.console.home_presentation.screen.BillPaymentScreen
import com.example.merybeltmobileapp.ui.console.home_presentation.screen.HomeScreen
import com.example.merybeltmobileapp.ui.console.home_presentation.screen.TransactionScreen
import com.example.merybeltmobileapp.ui.graph.Graph


@Composable
fun BottomNavGraph(
    navController: NavHostController,
    viewModel: ConsoleViewModel,
    localContext: Context,
    consoleState: ConsoleState,
    consoleEvent: (ConsoleEvent) -> Unit,
) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(
                navHostControllers = navController,
                localContext = localContext,
                viewModel = viewModel,
                consoleState = consoleState,
                consoleEventHandler = consoleEvent
            )
        }
        composable(route = BottomBarScreen.BillPayment.route) {
            BillPaymentScreen(
                navHostControllers = navController,
                localContext = localContext,
                viewModel = viewModel,
                consoleState = consoleState,
                consoleEventHandler = consoleEvent
            )
        }

        composable(route = BottomBarScreen.Transaction.route) {
            TransactionScreen(
                navHostControllers = navController,
                localContext = localContext,
                viewModel = viewModel,
                consoleState = consoleState,
                consoleEventHandler = consoleEvent
            )
        }

        detailsNavGraph(
            navController = navController,
            localContext = localContext,
            viewModel = viewModel,
            consoleState = consoleState,
            consoleEvent = consoleEvent
        )
    }
}

fun NavGraphBuilder.detailsNavGraph(
    navController: NavHostController,
    localContext: Context,
    viewModel: ConsoleViewModel,
    consoleState: ConsoleState,
    consoleEvent: (ConsoleEvent) -> Unit,
) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Transfer.route
    ){
        composable(route = DetailsScreen.Transfer.route) {
            TransferFunds(
                navController = navController,
                localContext = localContext,
                viewModel = viewModel,
                consoleState = consoleState,
                consoleEvent = consoleEvent
            )
        }
    }
}

sealed class DetailsScreen(val route: String) {
    object Transfer : DetailsScreen(route = "TRANSFER")
    object Withdraw : DetailsScreen(route = "WITHDRAW")
    object CreditAcc : DetailsScreen(route = "CREDITACC")
    object PayBill : DetailsScreen(route = "PAYBILL")
}

