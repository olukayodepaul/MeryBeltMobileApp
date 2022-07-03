package com.example.merybeltmobileapp.ui.screen.navigation

sealed class Screen(val route: String){
    object MainScreen: Screen(route = "main_screen")
    object HomeScreen: Screen(route = "home_screen")
}
