package com.example.merybeltmobileapp.ui.login.login_presentation.component

import android.content.Context
import android.widget.Toast
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
                                isDialogMessage = "",
                                isDialogShow = false
                            )
                        )
                    }
                )
                copyWrite(copyWriteYear="2022")

                LaunchedEffect(key1 = true) {
                    viewModel.uiEvent.collect { event ->
                        when (event) {
                            is ApiState.Success -> {
                                handleEvent(
                                    AuthenticationEvent.ShowUserDialog(
                                        isDialogMessage = event.album,
                                        isDialogShow = true
                                    )
                                )
                            }
                            else -> Unit
                        }
                    }
                }

            }
        }
    }
}

//when (apiState) {
//                    is ApiState.Loading -> {
//                        Toast.makeText(localContext, "Loading", Toast.LENGTH_SHORT).show()
//                    }
//                    is ApiState.Success -> {
//                        Toast.makeText(localContext, "Success", Toast.LENGTH_SHORT).show()
//                    }
//                    is ApiState.Error -> {
//                        Toast.makeText(localContext, "Error", Toast.LENGTH_SHORT).show()
//                    }
//                }