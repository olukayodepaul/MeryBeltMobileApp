package com.example.merybeltmobileapp.ui

import android.content.Context
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.example.merybeltmobileapp.ui.graph.Graph
import androidx.navigation.navigation
import androidx.navigation.compose.composable
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationEvent
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationState
import com.example.merybeltmobileapp.ui.login.login_presentation.AuthenticationViewModel
import com.example.merybeltmobileapp.ui.login.login_presentation.auth_component.LoginScreenTheme

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
    viewModel: AuthenticationViewModel,
    localContext: Context,
    authenticationState: AuthenticationState,
    handleEvent: (AuthenticationEvent) -> Unit,
    ) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreenTheme(
                navHostControllers  = navController,
                viewModel = viewModel,
                localContext = localContext,
                authenticationState = authenticationState,
                handleEvent = handleEvent
            )
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
    //object SignUp : AuthScreen(route = "SIGN_UP")
    //object Forgot : AuthScreen(route = "FORGOT")
}