package com.example.merybeltmobileapp.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.merybeltmobileapp.ui.console.home_ui.HomeMainScreen
import com.example.merybeltmobileapp.ui.login.login_data.ApiState
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationEvent
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationState
import com.example.merybeltmobileapp.ui.login.login_presentation.AuthenticationViewModel
import com.example.merybeltmobileapp.ui.login.login_presentation.component.LoginScreenThem


@Composable
fun setupNavGraph(
    navController: NavHostController,
    viewModel: AuthenticationViewModel = hiltViewModel(),
    localContext: Context,
    authenticationState: AuthenticationState,
    handleEvent: (AuthenticationEvent) -> Unit
){
    NavHost(
        navController = navController,
        startDestination = NaHost.MainScreen.route
    ){

        composable(
            route = NaHost.MainScreen.route
        ){
            LoginScreenThem(
                navHostControllers = navController,
                viewModel = viewModel,
                localContext = localContext,
                authenticationState = authenticationState,
                handleEvent = handleEvent
            )
        }
        composable(
            route = NaHost.HomeScreen.route
        ){
            HomeMainScreen()
        }
    }
}
