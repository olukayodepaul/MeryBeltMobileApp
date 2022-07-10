package com.example.merybeltmobileapp.ui.login.login_presentation.auth_component

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.merybeltmobileapp.theme.White
import com.example.merybeltmobileapp.ui.login.login_data.ApiState
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationEvent
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationState
import com.example.merybeltmobileapp.ui.login.login_presentation.AuthenticationViewModel
import com.example.merybeltmobileapp.ui.navigation.NaHost


@Composable
fun LoginScreenThem(
    navHostControllers: NavHostController,
    viewModel: AuthenticationViewModel = hiltViewModel(),
    localContext: Context,
    authenticationState: AuthenticationState,
    handleEvent: (AuthenticationEvent) -> Unit,
    ) {
    MaterialTheme{

        Column(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    color = White
                )
        ) {

            ImageLogo()

            Column(
                Modifier
                    .padding(20.dp)
                    .fillMaxSize()
                    .padding(top = 60.dp)

            ) {
                InputForms(
                    username = authenticationState.username,
                    onValueChange = {username->
                        handleEvent(
                            AuthenticationEvent.ChangeUserName(username)
                        )
                    },
                    label = "Username",
                )
                Spacer(modifier = Modifier.padding(bottom = 10.dp))
                PasswordFields (
                    username = authenticationState.password,
                    onValueChange = {password->
                        handleEvent(
                            AuthenticationEvent.ChangeUserPassword(password)
                        )
                    },
                    label = "Password"
                )
                Spacer(modifier = Modifier.padding(bottom = 10.dp))
                AuthenticationButtons(
                    title = "Login",
                    viewModel = viewModel,
                    uiState = authenticationState
                )
                Spacer(modifier = Modifier.padding(bottom = 15.dp))
                CircularPropagations(
                    status = authenticationState.loadingProgressBar
                )
                Spacer(modifier = Modifier.padding(bottom = 10.dp))
                AuthenticationErrorDialogs(
                    isDialogShow = authenticationState.isDialogShow,
                    isDialogMessage = authenticationState.isDialogMessage,
                    isDialogTitle = authenticationState.isDialogTitle,
                    onDismissRequest = {
                        handleEvent(
                            AuthenticationEvent.ShowUserDialog(
                                message = "",
                                viewStatus = false
                            )
                        )
                    }
                )

                copyWrite(copyWriteYear="2022")

                LaunchedEffect(key1 = true) {
                    viewModel.uiEvent.collect { event ->
                        when (event) {
                            is ApiState.Success -> {
                                if(event.status==200) {
                                    navHostControllers.navigate(route = NaHost.HomeScreen.route){
                                        popUpTo(NaHost.MainScreen.route) {
                                            inclusive = true
                                        }
                                    }
                                }
                            }
                            is ApiState.Error->{
                                handleEvent(
                                    AuthenticationEvent.ShowUserDialog(
                                        message = event.error,
                                        viewStatus = true
                                    )
                                )
                            }
                            else -> Unit
                        }
                        handleEvent(
                            AuthenticationEvent.ChangeUserProgressBar(
                                loader = false
                            )
                        )
                    }
                }
            }
        }
    }
}