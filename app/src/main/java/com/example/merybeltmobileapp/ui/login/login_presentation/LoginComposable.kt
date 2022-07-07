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

//            Column(
//                modifier = Modifier
//                    .padding(0.dp)
//                    .fillMaxWidth()
//                    .fillMaxHeight()
//                    .background(
//                        color = White
//                    )
//            ) {
//                Column(
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 60.dp)
//                ) {
//
//                    Image(
//                        painterResource(id = R.drawable.mb1200x630),
//                        modifier = Modifier
//                            .height(70.dp)
//                            .width(70.dp)
//                            .align(Alignment.CenterHorizontally),
//                        contentScale = ContentScale.Crop,
//                        contentDescription = "Logo",
//                    )
//
//                    OutlinedTextFields(
//                        label = "User Name",
//                        value = viewModel.userName,
//                        onValueChange = {viewModel.onUserStateChanged(it)}
//                    )
//
//                    OutlinedTextFields(
//                        label = "Password",
//                        visualTransformation = PasswordVisualTransformation(),
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//                        value = viewModel.userPassword,
//                        onValueChange = {viewModel.onUserStatePassword(it)}
//                    )
//
//
//
//                }
        //    }
        }
    }


