package com.example.merybeltmobileapp.ui.transfer.transfer_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.merybeltmobileapp.assets.Fonts
import com.example.merybeltmobileapp.theme.Buttons
import com.example.merybeltmobileapp.theme.MChild
import com.example.merybeltmobileapp.theme.White
import com.example.merybeltmobileapp.ui.dto.Specimen
import com.example.merybeltmobileapp.util.UtilCompose


@Composable
fun transferUI(){

//    var selectedSpecimen: Specimen? = null
//
//    val specimen = ArrayList<Specimen>()
//    specimen.add(Specimen(plantName = "Beautiful"))
//    specimen.add(Specimen(plantName = "Paul"))
//    specimen.add(Specimen(plantName = "Kayode"))
//
//    MaterialTheme {
//        Scaffold(
//            topBar = {
//                TopAppBar(
//                    title = {
//                        Text(
//                            text = "Transfer Fund",
//                            style = TextStyle(
//                                fontFamily = Fonts.Montserrat,
//                                fontSize = 14.sp
//                            )
//                        )
//                    },
//                    navigationIcon = {
//                        IconButton(onClick = {}) {
//                            Icon(Icons.Filled.ArrowBack,"backIcon", tint = White)
//                        }
//                    },
//                    backgroundColor = MChild,
//                    contentColor = Color.White,
//                    elevation = 0.dp
//                )
//            }, content = {
//                Column(
//                    modifier = Modifier
//                        .background(color = MChild)
//                        .fillMaxHeight()
//                        .fillMaxWidth(),
//                ) {
//
//                    Column(modifier = Modifier
//                        .height(100.dp)
//                        .fillMaxWidth()
//                        .background(color = MChild)
//                        .padding(20.dp),
//                        verticalArrangement = Arrangement.Center
//
//                    ) {
//
//                        Text(
//                            text = "Current Balance",
//                            style = TextStyle(
//                                fontFamily = Fonts.RobotoBold,
//                                color = White,
//                                fontSize = 13.sp
//                            ),
//                            modifier = Modifier
//                                .align(Alignment.CenterHorizontally),
//                        )
//
//                        Text(
//                            text = "3,533.00",
//                            modifier = Modifier
//                                .align(Alignment.CenterHorizontally),
//                            style = TextStyle(
//                                fontSize = 29.sp,
//                                fontFamily = Fonts.RobotoBold,
//                                color = White
//                            )
//                        )
//                    }
//
//                    Column(modifier = Modifier
//                        .fillMaxHeight()
//                        .fillMaxWidth(),
//                    ) {
//                        Column(
//                            modifier = Modifier
//                                .fillMaxHeight()
//                                .fillMaxWidth()
//                                .clip(RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp))
//                                .background(White)
//                                .padding(start = 20.dp, end = 20.dp),
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                        ){
//                            UtilCompose.UtilSpaceInBetween(40)
//                            UtilCompose.SpecimenSpinners(specimen,"Select Bank", 1)
//                            UtilCompose.InputWidget("Account Number",0)
//                            UtilCompose.InputWidget("Account Name",1)
//                            UtilCompose.InputWidget("Amount",2)
//                            UtilCompose.InputWidget("Remark",3)
//                            UtilCompose.UtilSpaceInBetween(5)
//                            Buttons("Continue")
//                        }
//                    }
//                }
//            }
//        )
//    }
}



//  MaterialTheme(
//
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(0.dp)
//                .fillMaxWidth()
//                .fillMaxHeight()
//                .background(
//                    color = White
//                )
//        ) {
//            Column(
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 60.dp)
//            ) {
//
//                Image(
//                    painterResource(id = R.drawable.mb1200x630),
//                    modifier = Modifier
//                        .height(70.dp)
//                        .width(70.dp)
//                        .align(Alignment.CenterHorizontally),
//                    contentScale = ContentScale.Crop,
//                    contentDescription = "Logo",
//                )
//
//                Spacer(modifier = Modifier.height(60.dp))
//
//                AuthenticationContent(
//                    localContext = localContext,
//                    modifier = Modifier,
//                    authenticationState = viewModel.uiState.collectAsState().value,
//                    dialogState = viewModel.showDialog.collectAsState().value,
//                    viewModel = viewModel,
//                    handleEvent = viewModel::handleEvent
//                )
//
//            }
//        }
//    }
//}
//
//@Composable
//fun AuthenticationContent(
//    localContext: Context,
//    modifier: Modifier = Modifier,
//    authenticationState: AuthenticationState,
//    dialogState: Boolean,
//    viewModel: AuthenticationViewModel = viewModel(),
//    handleEvent: (AuthenticationEvent) -> Unit,
//) {
//    AuthenticationForm(
//        modifier = modifier,
//        email = authenticationState.email,
//        password = authenticationState.password,
//        onEmailChanged = { email ->
//            handleEvent(
//                AuthenticationEvent.EmailChanged(email)
//            )
//        },
//        onPasswordChanged = { password ->
//            handleEvent(
//                AuthenticationEvent.PasswordChanged(password)
//            )
//        },
//        authenticationMode = authenticationState.authenticationMode,
//        localContext = localContext,
//        authenticationState = authenticationState,
//        handleEvent,
//        dialogState,
//        viewModel
//    )
//}
//
//
//@Composable
//fun AuthenticationForm(
//    modifier: Modifier = Modifier,
//    email: String,
//    password: String,
//    onEmailChanged: (String) -> Unit,
//    onPasswordChanged: (String) -> Unit,
//    authenticationMode: AuthenticationMode,
//    localContext: Context,
//    authenticationState: AuthenticationState,
//    handleEvent: (event: AuthenticationEvent) -> Unit,
//    dialogState:Boolean,
//    viewModel: AuthenticationViewModel = viewModel(),
//    ) {
//
//    Column(modifier.padding(20.dp)) {
//
//        InputForm(
//            painter = 2,
//            email = email,
//            label = "UserName",
//            onEmailChanged = onEmailChanged
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        PasswordInput(
//            modifier = modifier,
//            password = password,
//            onPasswordChanged = onPasswordChanged
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        AuthenticationButton(
//            modifier = modifier,
//            authenticationState = authenticationState,
//            handleEvent = handleEvent,
//            localContext = localContext,
//            title = "Login",
//            viewModel = viewModel
//        )
//
//        Row(
//            Modifier
//                .fillMaxWidth()
//                .padding(50.dp),
//            horizontalArrangement = Arrangement.Center
//        ) {
//            CircularProgressIndicator(
//                modifier = Modifier
//                    .width(30.dp)
//                    .height(30.dp),
//
//                )
//        }
//
//        AuthenticationErrorDialog(
//            dialogState = dialogState,
//            viewModel = viewModel
//        )
//    }
//}
//
//@Composable
//fun AuthenticationTitle(
//    modifier: Modifier = Modifier,
//    authenticationMode: AuthenticationMode
//) {
//    Text(
//        text = stringResource(
//            if (authenticationMode == AuthenticationMode.SIGN_IN) {
//                R.string.label_sign_in_to_account
//            } else {
//                R.string.label_sign_up_for_account
//            }
//        )
//    )
//}
//
//
//@Composable
//fun InputForm(
//    painter: Int = 0,
//    email: String,
//    label: String,
//    onEmailChanged: (String) -> Unit,
//    visualTransformation: VisualTransformation = VisualTransformation.None,
//    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
//) {
//
//    val bColor = Borderline
//    TextField(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(start = 10.dp, end = 10.dp),
//        value = email,
//        onValueChange = { email ->
//            onEmailChanged(email)
//        },
//        keyboardOptions = keyboardOptions.copy(keyboardType = KeyboardType.Text),
//        visualTransformation = visualTransformation,
//        label = {
//            Text(
//                text = label,
//                style = TextStyle(
//                    fontFamily = Fonts.Montserrat,
//                    color = Blues,
//                    fontSize = 18.sp
//                )
//            )
//        },
//        maxLines = 1,
//        //shape = RoundedCornerShape(6.dp),
//        leadingIcon = {
//            IconButton(onClick = {
//
//            }) {
//                Icon(
//                    imageVector = Icons.Default.Person,
//                    contentDescription = null
//                )
//            }
//        }
////        colors = TextFieldDefaults.outlinedTextFieldColors(
////            backgroundColor = Color(
////                bColor.red, bColor.green, bColor.blue,
////                TextFieldDefaults.BackgroundOpacity
////            ),
////            focusedBorderColor = bColor,
////            unfocusedBorderColor = Color(
////                bColor.red, bColor.green, bColor.blue,
////                TextFieldDefaults.UnfocusedIndicatorLineOpacity,
////            ),
////            focusedLabelColor = GreyTransparent,
////            cursorColor = GreyTransparent,
////        )
//    )
//}
//
//@Composable
//fun PasswordInput(
//    modifier: Modifier = Modifier,
//    password: String,
//    onPasswordChanged: (String) -> Unit,
//    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
//) {
//    var isPasswordHidden by remember {
//        mutableStateOf(true)
//    }
//
//    TextField(
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(start = 10.dp, end = 10.dp),
//        value = password,
//        onValueChange = { password ->
//            onPasswordChanged(password)
//        },
//        keyboardOptions = keyboardOptions.copy(
//            keyboardType = KeyboardType.Text,
//            imeAction = ImeAction.Next
//        ),
//        singleLine = true,
//        label = {
//            Text(
//                text = stringResource(id = R.string.label_password),
//                style = TextStyle(
//                    fontFamily = Fonts.Montserrat,
//                    color = Blues,
//                    fontSize = 18.sp
//                )
//            )
//        },
//        leadingIcon = {
//            Icon(
//                imageVector = Icons.Default.Lock,
//                contentDescription = null
//            )
//        },
//        trailingIcon = {
//            Icon(
//                modifier = Modifier.clickable(
//                    onClickLabel = if (isPasswordHidden) {
//                        stringResource(id = R.string.cd_show_password)
//                    } else stringResource(id = R.string.cd_hide_password)
//                ) {
//                    isPasswordHidden = !isPasswordHidden
//                },
//                painter = if (isPasswordHidden) {
//                    painterResource(R.drawable.ic_baseline_visibility_24)
//                } else painterResource(R.drawable.ic_baseline_visibility_off_24),
//                contentDescription = null
//            )
//        }
//    )
//}
//
//
//@Composable
//fun AuthenticationButton(
//    modifier: Modifier = Modifier,
//    authenticationState: AuthenticationState,
//    handleEvent: (event: AuthenticationEvent) -> Unit,
//    localContext: Context,
//    title: String = "",
//    viewModel: AuthenticationViewModel = viewModel(),
//) {
//    Button(
//        onClick = {
//
//        },
//        //enabled = false,
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(start = 10.dp, end = 10.dp),
//        colors = ButtonDefaults.buttonColors(
//            backgroundColor = MChild
//        ),
//    ) {
//        Text(
//            text = title,
//            style = TextStyle(
//                color = White,
//                fontSize = 20.sp,
//                fontFamily = Fonts.MontserratBold
//            ),
//        )
//    }
//}
//
//
//@Composable
//fun AuthenticationErrorDialog(
//    dialogState: Boolean,
//    viewModel: AuthenticationViewModel = viewModel(),
//) {
//
//    if (dialogState) {
//
//        AlertDialog(
//            onDismissRequest = {viewModel.onDialogConfirm(false)},
//            buttons = {
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    contentAlignment = Alignment.CenterEnd
//                ) {
//                    TextButton(
//                        onClick = {
//                            viewModel.onDialogConfirm(false)
//                        }
//                    ) {
//                        Text(
//                            text = stringResource(
//                                id = R.string.error_action
//                            )
//                        )
//                    }
//                }
//            },
//            title = {
//                Text(
//                    text = stringResource(
//                        id = R.string.error_title
//                    ),
//                    fontSize = 18.sp
//                )
//            },
//            text = {
//                Text(
//                    text = "xgsv"
//                )
//            }
//        )
//    }
//}