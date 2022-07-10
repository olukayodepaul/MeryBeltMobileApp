package com.example.merybeltmobileapp.ui.console.home_presentation.console_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.merybeltmobileapp.R
import com.example.merybeltmobileapp.assets.Fonts
import com.example.merybeltmobileapp.theme.Blues
import com.example.merybeltmobileapp.ui.console.home_presentation.screen.changeBgColor
import com.example.merybeltmobileapp.ui.console.home_presentation.screen.getNameInitialsBg

@Composable
fun routers(
    navController: NavController? = null,
    imageSwitchers: Int = 0,
    routerLinkName: String = "",
    route: String = ""
){


    Card(
        elevation = 3.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(10.dp)
        ) {

            Card(
                shape = RoundedCornerShape(3.dp),
                modifier = Modifier.padding(5.dp)
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .background(changeBgColor(imageSwitchers))
                        .height(30.dp)
                        .width(30.dp)
                        .padding(5.dp),
                    verticalArrangement = Arrangement.Center,

                    ) {

                    Image(
                        painterResource(id = getNameInitialsBg(imageSwitchers)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .align(Alignment.CenterHorizontally),
                        contentScale = ContentScale.Crop,
                        contentDescription = "Logo",
                    )
                }
            }

            Text(
                text = routerLinkName,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = Fonts.Montserrat,
                    color = Blues
                )

            )

            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, top = 9.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Image(
                    painterResource(id = R.drawable.ic_baseline_navigate_next_24),
                    modifier = Modifier
                        .height(25.dp)
                        .width(25.dp)
                        .align(Alignment.End),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Logo",
                )
            }
        }

    }
}
