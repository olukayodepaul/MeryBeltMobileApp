package com.example.merybeltmobileapp.ui.console.home_presentation

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.merybeltmobileapp.assets.Fonts
import com.example.merybeltmobileapp.theme.*
import com.example.merybeltmobileapp.ui.console.home_data.ConsoleEvent
import com.example.merybeltmobileapp.ui.console.home_data.ConsoleState
import com.example.merybeltmobileapp.ui.console.home_presentation.console_component.BankList
import com.example.merybeltmobileapp.ui.console.home_presentation.console_component.Buttons
import com.example.merybeltmobileapp.ui.console.home_presentation.console_component.OutlinedTextFields


@Composable
fun TransferFunds(
    navController: NavHostController,
    localContext: Context,
    consoleState: ConsoleState,
    consoleEventHandler: (ConsoleEvent) -> Unit
){
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Transfer Fund",
                            style = TextStyle(
                                fontFamily = Fonts.Montserrat,
                                fontSize = 14.sp
                            )
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.ArrowBack,"backIcon", tint = White)
                        }
                    },
                    backgroundColor = MChild,
                    contentColor = Color.White,
                    elevation = 0.dp
                )
            }, content = {
                Column(
                    modifier = Modifier
                        .background(color = MChild)
                        .fillMaxHeight()
                        .fillMaxWidth(),
                ) {

                    Column(modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .background(color = MChild)
                        .padding(20.dp),
                        verticalArrangement = Arrangement.Center

                    ) {

                        Text(
                            text = "Current Balance",
                            style = TextStyle(
                                fontFamily = Fonts.RobotoBold,
                                color = White,
                                fontSize = 13.sp
                            ),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally),
                        )

                        Text(
                            text = consoleState.balance,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally),
                            style = TextStyle(
                                fontSize = 29.sp,
                                fontFamily = Fonts.RobotoBold,
                                color = White
                            )
                        )
                    }

                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp))
                                .background(White)
                                .padding(start = 20.dp, end = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ){
                            Row(Modifier.height(70.dp)){
                                Box(modifier = Modifier
                                    .width(55.dp)
                                    .height(64.dp)
                                    .padding(top = 8.dp, end = 5.dp)
                                    .border(width = 1.dp, color = MaterialBg)
                                    .clip(shape = RoundedCornerShape(10.dp))
                                    .border(
                                        BorderStroke(
                                            width = 1.dp, color = Borderline
                                        )
                                    ),
                                    contentAlignment = Alignment.Center

                                ){

                                    if(consoleState.bankLogo.isEmpty()){
                                        Icon(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .fillMaxHeight()
                                                .padding(7.dp),
                                            painter = painterResource(id = cusIcon(1)),
                                            contentDescription = "Logo"
                                        )
                                    }else{
                                        val leadingIcon = rememberImagePainter(data = consoleState.bankLogo,
                                            builder =  {
                                            }
                                        )
                                        Image(
                                            painter = leadingIcon,
                                            contentDescription = "logo",
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .fillMaxHeight()
                                                .padding(7.dp),
                                        )
                                        val painterState = leadingIcon.state
                                        if(painterState is ImagePainter.State.Loading){
                                            CircularProgressIndicator(
                                                color = MChild
                                            )
                                        }
                                    }
                                }
                                BankList(
                                    localContext = localContext,
                                    consoleState = consoleState,
                                    consoleEventHandler = consoleEventHandler
                                )

                            }

                            OutlinedTextFields(
                                label = "Account Number"
                            )

                            OutlinedTextFields(
                                label = "Account Name"
                            )

                            OutlinedTextFields(
                                label = "Account Amount"
                            )

                            OutlinedTextFields(
                                label = "Account Remark"
                            )

                            Buttons(
                                label = "Next"
                            )

                        }
                    }
                }
            }
        )
    }
}