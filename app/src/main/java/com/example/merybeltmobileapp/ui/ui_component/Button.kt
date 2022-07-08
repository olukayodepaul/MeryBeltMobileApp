package com.example.merybeltmobileapp.ui.ui_component

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.merybeltmobileapp.assets.Fonts
import com.example.merybeltmobileapp.theme.MChild
import com.example.merybeltmobileapp.theme.White


@Composable
fun SubmitButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Int

){
    Button(
        onClick = {

        },
        modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, top = 10.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MChild
        ),

        ) {
        Text(
            text =text,
            style = TextStyle(
                color = White,
                fontSize = 20.sp,
                fontFamily = Fonts.MontserratBold
            ),
        )
    }
}