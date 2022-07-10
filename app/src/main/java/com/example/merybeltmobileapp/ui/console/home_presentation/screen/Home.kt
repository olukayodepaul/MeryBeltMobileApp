package com.example.merybeltmobileapp.ui.console.home_presentation.screen


import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.merybeltmobileapp.assets.Fonts.Montserrat
import com.example.merybeltmobileapp.assets.Fonts.RobotoBold
import com.example.merybeltmobileapp.theme.MChild
import com.example.merybeltmobileapp.theme.White
import com.example.merybeltmobileapp.ui.console.home_data.ConsoleEvent
import com.example.merybeltmobileapp.ui.console.home_presentation.ConsoleViewModel


@Composable
fun HomeScreen(
    navController: NavHostController,
    localContext: Context,
    viewModel: ConsoleViewModel,
    consoleEventHandler: (ConsoleEvent)->Unit
) {

    val state = viewModel.uiState.collectAsState().value

    MaterialTheme{
        Column(
            modifier = Modifier
                .background(color = MChild)
                .fillMaxHeight()
                .fillMaxWidth(),
        ) {

            Column(modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .background(color = MChild)
                .padding(20.dp),
                verticalArrangement = Arrangement.Center

            ) {
                Text(text = "Available Balance",
                    modifier = Modifier
                        .align(Alignment.Start),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = RobotoBold,
                        color = White,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.padding(bottom = 5.dp))

                Text(text = state.customerId,
                    modifier = Modifier
                        .align(Alignment.Start),
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = Montserrat,
                        color = White,
                        fontWeight = FontWeight.Bold,
                    )
                )

                Text(
                    text = state.balance,
                    modifier = Modifier
                        .align(Alignment.Start),
                    style = TextStyle(
                        fontSize = 25.sp,
                        fontFamily = RobotoBold,
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

                }
            }
        }
    }

}