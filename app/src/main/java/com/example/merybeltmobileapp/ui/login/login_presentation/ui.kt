package com.example.merybeltmobileapp.ui.login.login_presentation

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.merybeltmobileapp.theme.White
import com.example.merybeltmobileapp.util.isTransferLeadingIcon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext


@Composable
fun Authentication() {

    val viewModel: AuthenticationViewModel = viewModel()
    val localContext = LocalContext.current

    MaterialTheme {
        Column(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    color = White
                )
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp)
            ) {

                Image(
                    painterResource(id = R.drawable.mb1200x630),
                    modifier = Modifier
                        .height(70.dp)
                        .width(70.dp)
                        .align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Logo",
                )
                AuthenticationContent(
                    localContext = localContext,
                    modifier = Modifier,
                    authenticationState = viewModel.uiState.collectAsState().value,
                    handleEvent = viewModel::handleEvent
                )

            }
        }
    }
}

@Composable
fun AuthenticationContent(
    localContext: Context,
    modifier: Modifier = Modifier,
    authenticationState: AuthenticationState,
    handleEvent: (AuthenticationEvent) -> Unit,
) {
    if (authenticationState.isLoading) {
        CircularProgressIndicator()
    } else {
        AuthenticationForm(
            modifier = modifier,
            email = authenticationState.email,
            password = authenticationState.password,
            onEmailChanged = { email ->
                handleEvent(
                    AuthenticationEvent.EmailChanged(email)
                )
            },
            onPasswordChanged = { password ->
                handleEvent(
                    AuthenticationEvent.PasswordChanged(password)
                )
            },
            authenticationMode = authenticationState.authenticationMode,
            localContext = localContext,
            authenticationState = authenticationState,
            handleEvent
        )
    }
}

@Composable
fun AuthenticationForm(
    modifier: Modifier = Modifier,
    email: String,
    password: String,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    authenticationMode: AuthenticationMode,
    localContext: Context,
    authenticationState: AuthenticationState,
    handleEvent: (event: AuthenticationEvent) -> Unit,

) {

    Column(modifier.padding(20.dp)) {

        InputForm(
            painter = 2,
            email = email,
            label = "UserName",
            onEmailChanged = onEmailChanged
        )

        PasswordInput(
            modifier = modifier,
            password = password,
            onPasswordChanged = onPasswordChanged
        )

        AuthenticationButton(
            modifier  = modifier,
            authenticationState = authenticationState,
            handleEvent = handleEvent,
            localContext =  localContext
        )
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
fun InputForm(
    painter: Int = 0,
    email: String,
    label: String,
    onEmailChanged: (String) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {

    val bColor = Borderline
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = email,
        onValueChange = {email->
            onEmailChanged(email)
        },
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
                    contentDescription = ""
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

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    password: String,
    onPasswordChanged: (String) -> Unit,
) {
    var isPasswordHidden by remember {
        mutableStateOf(true)
    }

    TextField(
        modifier = modifier,
        value = password,
        onValueChange = {password->
            onPasswordChanged(password)
        },
        singleLine = true,
        label = {
            Text(
                text = stringResource(id = R.string.label_password),
                style = TextStyle(
                    fontFamily = Fonts.Montserrat,
                    color = Blues,
                    fontSize = 18.sp
                )
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null
            )
        },
        trailingIcon = {
            Icon(
                modifier = Modifier.clickable(
                    onClickLabel = if (isPasswordHidden) {
                        stringResource(id = R.string.cd_show_password)
                    } else stringResource(id = R.string.cd_hide_password)
                ) {
                    isPasswordHidden = !isPasswordHidden
                },
                painter = if (isPasswordHidden) {
                    painterResource(R.drawable.ic_baseline_visibility_24)
                } else painterResource(R.drawable.ic_baseline_visibility_off_24),
                contentDescription = null
            )
        }
    )
}


@Composable
fun AuthenticationButton(
    modifier: Modifier = Modifier,
    authenticationState: AuthenticationState,
    handleEvent: (event: AuthenticationEvent) -> Unit,
    localContext: Context
) {

    Button(
        onClick = {
            if(authenticationState.email.isEmpty()){
                Toast.makeText(localContext, "Wrong Longin Credential",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(localContext, "Wrong Longin ${authenticationState.email}",Toast.LENGTH_SHORT).show()
            }
        }
    ) {

    }

}


