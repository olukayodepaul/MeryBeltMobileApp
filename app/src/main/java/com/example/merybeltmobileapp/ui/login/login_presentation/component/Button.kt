package com.example.merybeltmobileapp.ui.login.login_presentation.component


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.merybeltmobileapp.assets.Fonts
import com.example.merybeltmobileapp.theme.MChild
import com.example.merybeltmobileapp.theme.White
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationEvent


@Composable
fun AuthenticationButtons(
    title:String = "",
    handleEvent :(AuthenticationEvent)->Unit
) {
    Button(
        onClick = {
            handleEvent(
                AuthenticationEvent.apiNetwork
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MChild
        ),
    ) {
        Text(
            text = title,
            style = TextStyle(
                color = White,
                fontSize = 20.sp,
                fontFamily = Fonts.MontserratBold
            ),
        )
    }
}
