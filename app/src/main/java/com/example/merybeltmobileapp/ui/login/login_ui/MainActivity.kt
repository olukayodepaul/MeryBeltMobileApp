package com.example.merybeltmobileapp.ui.login.login_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.merybeltmobileapp.ui.login.login_ui.LoginComposable.loginUi


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            loginUi(applicationContext)
        }
    }
}
