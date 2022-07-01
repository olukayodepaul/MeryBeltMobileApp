package com.example.merybeltmobileapp.ui.home.home_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.merybeltmobileapp.theme.MeryBeltMobileAppTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeryBeltMobileAppTheme {
                MainScreen()
            }
        }
    }
}
