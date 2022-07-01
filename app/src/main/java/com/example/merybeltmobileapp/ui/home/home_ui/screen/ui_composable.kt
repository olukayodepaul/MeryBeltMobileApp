package com.example.merybeltmobileapp.ui.home.home_ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.merybeltmobileapp.assets.Fonts
import com.example.merybeltmobileapp.theme.Blues
import com.example.merybeltmobileapp.R
import com.example.merybeltmobileapp.theme.Blu
import com.example.merybeltmobileapp.theme.Purple200
import com.example.merybeltmobileapp.theme.reds


@Composable
fun Links(title:String, switchImage: Int){


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
                        .background(changeBgColor(switchImage))
                        .height(30.dp)
                        .width(30.dp)
                        .padding(5.dp),
                    verticalArrangement = Arrangement.Center,

                    ) {

                    Image(
                        painterResource(id = getNameInitialsBg(switchImage)),
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
                text = title,
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

@Composable
fun getNameInitialsBg(switchImage: Int):Int {
    val drawables = arrayOf(
        R.drawable.ic_baseline_domain_add_24, R.drawable.ic_baseline_business_center_24, R.drawable.ic_baseline_swap_horiz_24,
        R.drawable.ic_baseline_payments_24
    )
    return drawables[switchImage]
}

@Composable
fun changeBgColor(switchColor: Int): Color {
    val color = arrayOf(
        Blues, Blu, Purple200, reds
    )
    return color[switchColor]
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}