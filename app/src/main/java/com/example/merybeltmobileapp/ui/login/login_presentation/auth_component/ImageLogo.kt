package com.example.merybeltmobileapp.ui.login.login_presentation.auth_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.merybeltmobileapp.R


@Composable
fun ImageLogo() {
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
                .height(90.dp)
                .width(90.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop,
            contentDescription = "Logo",
        )
    }
}