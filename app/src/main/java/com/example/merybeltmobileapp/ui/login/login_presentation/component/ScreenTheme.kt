package com.example.merybeltmobileapp.ui.login.login_presentation.component

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.merybeltmobileapp.theme.White
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationEvent
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationState
import com.example.merybeltmobileapp.ui.login.login_presentation.AuthenticationViewModel


@Composable
fun ScreenThem(
    viewModel: AuthenticationViewModel = hiltViewModel(),
    localContext: Context,
    authenticationState: AuthenticationState,
    handleEvent: (AuthenticationEvent) -> Unit
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
                    handleEvent = handleEvent,
                    authenticationState = authenticationState
                )
                Spacer(modifier = Modifier.padding(bottom = 10.dp))
                CircularPropagations(
                    status = authenticationState.loadingProgressBar
                )
                Spacer(modifier = Modifier.padding(bottom = 10.dp))
                AuthenticationErrorDialogs(
                    status = authenticationState.isDialog,
                    message = "Close",
                    title = ""
                )

                copyWrite(copyWriteYear="2022")
            }
        }
    }
}
//authenticationState: AuthenticationState,
//    handleEvent: (AuthenticationEvent) -> Unit,
//    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
//    label:String = "",
//    modifier: Modifier = Modifier,
//    visualTransformation: VisualTransformation = VisualTransformation.None,


// viewModel = viewModel,
//                localContext = localContext,
//                modifier = modifier,
//                authenticationState = authenticationState,
//                handleEvent = handleEvent