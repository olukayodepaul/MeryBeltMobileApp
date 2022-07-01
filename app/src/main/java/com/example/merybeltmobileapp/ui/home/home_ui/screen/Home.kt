package com.example.merybeltmobileapp.ui.home.home_ui.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.merybeltmobileapp.assets.Fonts.Montserrat
import com.example.merybeltmobileapp.assets.Fonts.RobotoBold
import com.example.merybeltmobileapp.theme.MChild
import com.example.merybeltmobileapp.theme.White
import com.example.merybeltmobileapp.util.UtilCompose.UtilSpaceInBetween


@Composable
fun HomeScreen() {
    MaterialTheme{
        val shape = RoundedCornerShape(12.dp)
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

                Text(text = "012199039",
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
                    text = "3,533.00",
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
                    UtilSpaceInBetween(35)
                    Links("Credit Account",0)
                    UtilSpaceInBetween(5)
                    Links("Withdraw",1)
                    UtilSpaceInBetween(5)
                    Links("Transfer",2)
                    UtilSpaceInBetween(5)
                    Links("Bill payment",3)
                }
            }
        }
    }
}
