package com.example.merybeltmobileapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.merybeltmobileapp.theme.MeryBeltMobileAppTheme
import com.example.merybeltmobileapp.ui.login.login_presentation.Authentication
import com.example.merybeltmobileapp.ui.login.login_presentation.AuthenticationViewModel
import com.example.merybeltmobileapp.ui.login.login_presentation.loginUi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: AuthenticationViewModel = hiltViewModel()
            MeryBeltMobileAppTheme {
                Authentication()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MeryBeltMobileAppTheme {
        Greeting("Android")
    }
}