package com.example.merybeltmobileapp.ui.login.login_presentation


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.merybeltmobileapp.R
import com.example.merybeltmobileapp.assets.Fonts
import com.example.merybeltmobileapp.assets.Fonts.MontserratBold
import com.example.merybeltmobileapp.theme.MChild
import com.example.merybeltmobileapp.theme.Menus
import com.example.merybeltmobileapp.theme.White
import com.example.merybeltmobileapp.ui.login.login_data.login_dto.LoginCredential
import com.example.merybeltmobileapp.util.UtilCompose.UtilSpaceInBetween
import com.example.merybeltmobileapp.util.currentDate
import com.example.merybeltmobileapp.util.getHash
import java.text.SimpleDateFormat
import java.util.*


@Composable
    fun loginUi() {
        MaterialTheme{

            var navController: NavController
            var viewModel: LoginViewModel = hiltViewModel()

            val userName  = viewModel.userName.value
            val userPassword  = viewModel.userPassword.value
            val context = LocalContext.current

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
                    UtilSpaceInBetween(100)

                    TextField(
                        label = { Text(text = "Username")},
                        value = userName,
                        onValueChange = {
                            viewModel.onChangeUserName(it)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp, top = 10.dp)
                    )

                    TextField(
                        label = { Text(text = "Password")},
                        value = userPassword,
                        onValueChange = {
                            viewModel.onChangeUserPassword(it)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp, top = 10.dp)
                    )

                    Button(

                        onClick = {
                            if(userName.isEmpty() ||  userPassword.isEmpty()) {
                                Toast.makeText(context, "Invalid Login", Toast.LENGTH_SHORT).show()
                            }else{
                                val us = "external_user"
                                val pas = "[2,40,-18,-22,-8,37,-96,-61,-54,-78,18,-107,11,-110,-34,107]"
                                val loginCredential = LoginCredential(us,pas)
                                viewModel.onEvent(TrackerOverviewEvent.OnClick(loginCredential))
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp, top = 10.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MChild
                        ),

                        ) {
                        androidx.compose.material.Text(
                            text = "Login",
                            style = TextStyle(
                                color = White,
                                fontSize = 20.sp,
                                fontFamily = Fonts.MontserratBold
                            ),
                        )
                    }

                    copyWrite("2022")
                }
            }
        }
    }

    @Composable
    fun copyWrite(copyWriteYear:String){
        Box(modifier = Modifier.fillMaxSize()) {
            ClickableText(
                text = AnnotatedString("© $copyWriteYear Merry Belt. All Rights Reserved."),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(20.dp),
                onClick = {},
                style = TextStyle(
                    fontSize = 10.sp,
                    fontFamily = MontserratBold,
                    //textDecoration = TextDecoration.Underline,
                    color = Menus
                )
            )
        }
    }
