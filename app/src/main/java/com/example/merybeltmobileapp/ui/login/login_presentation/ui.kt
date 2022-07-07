package com.example.merybeltmobileapp.ui.login.login_presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.merybeltmobileapp.R
import com.example.merybeltmobileapp.assets.Fonts
import com.example.merybeltmobileapp.theme.Blues
import com.example.merybeltmobileapp.theme.Borderline
import com.example.merybeltmobileapp.theme.GreyTransparent
import com.example.merybeltmobileapp.util.isTransferLeadingIcon


@Composable
fun Authentication() {

    val viewModel: AuthenticationViewModel = viewModel()

    MaterialTheme {
        AuthenticationContent(
            modifier = Modifier,
            authenticationState = viewModel.uiState.collectAsState().value,
            handleEvent = viewModel::handleEvent
        )
    }
}

@Composable
fun AuthenticationContent(
    modifier: Modifier = Modifier,
    authenticationState: AuthenticationState,
    handleEvent: (event: AuthenticationEvent) -> Unit
) {
    if (authenticationState.isLoading) {
        CircularProgressIndicator()
    } else {
        AuthenticationForm(
            modifier = modifier,
            email = authenticationState.email,
            authenticationMode = authenticationState.authenticationMode,
            onEmailChanged = {
                email ->  handleEvent(
                    AuthenticationEvent.EmailChanged(email)
                )
            }
        )
    }
}

@Composable
fun AuthenticationForm(
    modifier: Modifier = Modifier,
    email: String?,
    authenticationMode: AuthenticationMode,
    onEmailChanged: (email: String) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        AuthenticationTitle(
            authenticationMode = authenticationMode
        )
        Spacer(modifier = Modifier.height(40.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                EmailInput(
                    modifier = Modifier.fillMaxWidth(),
                    email = email ?: "",
                    onEmailChanged = onEmailChanged
                )
            }
        }
    }
}

@Composable
fun AuthenticationTitle(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode
) {
    Text(
        text = stringResource(
            if (authenticationMode == AuthenticationMode.SIGN_IN) {
                R.string.label_sign_in_to_account
            } else {
                R.string.label_sign_up_for_account
            }
        )
    )
}


@Composable
fun EmailInput(
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    painter:Int=0,

    onValueChange:(String)->Unit,
) {

    val bColor = Borderline
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        label = {
            Text(
                text = label,
                style = TextStyle(
                    fontFamily = Fonts.Montserrat,
                    color = Blues,
                    fontSize = 18.sp
                )
            )
        },
        maxLines = 1,
        shape = RoundedCornerShape(6.dp),
        leadingIcon = {
            IconButton(onClick = {

            }) {
                Icon(
                    painter = painterResource(id = isTransferLeadingIcon(painter)),
                    contentDescription = label
                )
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color(
                bColor.red, bColor.green, bColor.blue,
                TextFieldDefaults.BackgroundOpacity
            ),
            focusedBorderColor = bColor,
            unfocusedBorderColor = Color(
                bColor.red, bColor.green, bColor.blue,
                TextFieldDefaults.UnfocusedIndicatorLineOpacity,
            ),
            focusedLabelColor = GreyTransparent,
            cursorColor = GreyTransparent,
        )
    )
}

