package com.example.merybeltmobileapp.ui.login.login_presentation


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
import com.example.merybeltmobileapp.ui.screen.navigation.Screen
import com.example.merybeltmobileapp.util.SubmitButton
import com.example.merybeltmobileapp.util.UtilCompose.UtilSpaceInBetween


    @Composable
    fun loginUi(
        navController: NavController,
        viewModel: LoginViewModel = hiltViewModel(),
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
                    InputForm("Username")
                    InputForm("Password")

                    Button(
                        onClick = {
                            Log.d("EPOKHAI","cLICKING  ")
                            navController!!.navigate(route = Screen.HomeScreen.route)
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
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
    fun InputForm(
        hint:String
    ) {
        TextField(
            label = { Text(text = "$hint")},
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 10.dp)
        )
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
