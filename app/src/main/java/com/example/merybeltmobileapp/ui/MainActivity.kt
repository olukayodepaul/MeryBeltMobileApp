package com.example.merybeltmobileapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.merybeltmobileapp.theme.MeryBeltMobileAppTheme
import com.example.merybeltmobileapp.ui.login.login_presentation.Authentication
import com.example.merybeltmobileapp.ui.login.login_presentation.AuthenticationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: AuthenticationViewModel = hiltViewModel()
            val localContext = LocalContext.current
            MeryBeltMobileAppTheme {
                Authentication(
                    viewModel = viewModel,
                    localContext = localContext
                )
            }
        }
    }
}
