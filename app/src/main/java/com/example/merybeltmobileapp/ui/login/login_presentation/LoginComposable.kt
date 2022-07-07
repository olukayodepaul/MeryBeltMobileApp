package com.example.merybeltmobileapp.ui.login.login_presentation



import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel



@OptIn(ExperimentalComposeUiApi::class)
@Composable
    fun loginUi(viewModel: AuthenticationViewModel = hiltViewModel()) {

    viewModel.handleEvent(
        AuthenticationEvent.ToggleAuthenticationMode
    )

        MaterialTheme{

        }
    }


