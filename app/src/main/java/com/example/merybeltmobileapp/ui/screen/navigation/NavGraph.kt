package com.example.merybeltmobileapp.ui.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.merybeltmobileapp.ui.home.home_ui.HomeMainScreen
import com.example.merybeltmobileapp.ui.login.login_presentation.loginUi

@Composable
fun setupNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ){

        composable(
            route = Screen.MainScreen.route
        ){
            loginUi()
        }

        composable(
            route = Screen.HomeScreen.route
        ){
            HomeMainScreen()
        }

    }
}
