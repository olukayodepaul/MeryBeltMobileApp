package com.example.merybeltmobileapp.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.merybeltmobileapp.ui.console.home_data.ConsoleEvent
import com.example.merybeltmobileapp.ui.console.home_data.ConsoleState
import com.example.merybeltmobileapp.ui.console.home_presentation.TransferFunds
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationEvent
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationState
import com.example.merybeltmobileapp.ui.login.login_presentation.AuthenticationViewModel
import com.example.merybeltmobileapp.ui.login.login_presentation.auth_component.LoginScreenThem


@Composable
fun setupNavGraph(
    navController: NavHostController,
    viewModel: AuthenticationViewModel = hiltViewModel(),
    localContext: Context,
    authenticationState: AuthenticationState,
    handleEvent: (AuthenticationEvent) -> Unit, //Auth event
    consoleState : ConsoleState,
    consoleEvent: (ConsoleEvent) -> Unit
){
    NavHost(
        navController = navController,
        startDestination = NaHost.MainScreen.route
    ){

        composable(
            route = NaHost.MainScreen.route
        ){
            TransferFunds(
                navController = navController,
                localContext =  localContext,
                consoleState = consoleState,
                consoleEventHandler = consoleEvent
            )
        }

        //NaHost.HomeScreen.route
        composable(
            route = NaHost.CreditScreen.route
        ){
            LoginScreenThem(
                navHostControllers = navController,
                viewModel = viewModel,
                localContext = localContext,
                authenticationState = authenticationState,
                handleEvent = handleEvent
            )
        }
    }
}


