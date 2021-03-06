package com.example.merybeltmobileapp.ui.login.login_presentation.auth_component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.merybeltmobileapp.assets.Fonts.MontserratBold
import com.example.merybeltmobileapp.theme.Menus

@Composable
fun copyWrite(
    copyWriteYear:String
){
    Box(modifier = Modifier.fillMaxSize()) {
        ClickableText(
            text = AnnotatedString("© $copyWriteYear Merry Belt. All Rights Reserved."),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onClick = {},
            style = TextStyle(
                fontSize = 13.sp,
                fontFamily = MontserratBold,
                //textDecoration = TextDecoration.Underline,
                color = Menus
            )
        )
    }
}
