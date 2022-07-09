package com.example.merybeltmobileapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.merybeltmobileapp.ui.home.home_ui.HomeMainScreen


@Composable
fun setupNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Route.MainScreen.route
    ){

        composable(
            route = Route.MainScreen.route
        ){

        }

        composable(
            route = Route.HomeScreen.route
        ){

        }

    }
}
