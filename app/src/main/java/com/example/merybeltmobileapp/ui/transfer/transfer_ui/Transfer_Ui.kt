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