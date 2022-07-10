package com.example.merybeltmobileapp.ui.navigation

sealed class NaHost(val route: String){
    object MainScreen: NaHost(route = "main_screen")
    object HomeScreen: NaHost(route = "home_screen")
}
