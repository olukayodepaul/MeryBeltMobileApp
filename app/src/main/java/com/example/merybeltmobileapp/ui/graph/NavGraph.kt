package com.example.merybeltmobileapp.ui.graph

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.merybeltmobileapp.ui.console.home_data.ConsoleEvent
import com.example.merybeltmobileapp.ui.console.home_data.ConsoleState
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationEvent
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationState
import com.example.merybeltmobileapp.ui.login.login_presentation.AuthenticationViewModel
import androidx.navigation.compose.composable
import com.example.merybeltmobileapp.ui.authNavGraph
import com.example.merybeltmobileapp.ui.console.home_presentation.ConsoleViewModel
import com.example.merybeltmobileapp.ui.console.home_presentation.bottom_navigation.HomeMainScreen


@Composable
fun setupNavGraph(
    navController: NavHostController,
    viewModel: AuthenticationViewModel,
    consoleViewModel: ConsoleViewModel,
    localContext: Context,
    authenticationState: AuthenticationState,
    handleEvent: (AuthenticationEvent) -> Unit, //Auth event
    consoleState : ConsoleState,
    consoleEvent: (ConsoleEvent) -> Unit
){
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(
            navController = navController,
            viewModel = viewModel,
            localContext = localContext,
            authenticationState = authenticationState,
            handleEvent = handleEvent
        )
        composable(route = Graph.HOME) {
            HomeMainScreen(
                navController = navController,
                viewModel = consoleViewModel,
                localContext = localContext,
                consoleState = consoleState,
                consoleEvent = consoleEvent
            )
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}
