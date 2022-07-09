package com.example.merybeltmobileapp.ui.navigation

sealed class Route(val route: String){
    object MainScreen: Route(route = "main_screen")
    object HomeScreen: Route(route = "home_screen")
}
