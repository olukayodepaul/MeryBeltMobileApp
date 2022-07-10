package com.example.merybeltmobileapp.ui.login.login_presentation.auth_component


import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.merybeltmobileapp.assets.Fonts
import com.example.merybeltmobileapp.theme.MChild

@Composable
fun AuthenticationErrorDialogs (
    isDialogShow : Boolean,
    isDialogMessage: String,
    isDialogTitle: String = "",
    onDismissRequest:()->Unit

) {
    if(isDialogShow) {
        AlertDialog(
            onDismissRequest = {
                onDismissRequest()
            },
            confirmButton = {
                TextButton(onClick = {
                    onDismissRequest()
                })
                {
                    Text(
                        text = "Close",
                        style = TextStyle(
                            color = MChild,
                            fontFamily = Fonts.Montserrat,
                            fontSize = 14.sp
                        )
                    )
                }
            },
            title = {
                Text(text = isDialogTitle)
            },
            text = {
                Text(text = isDialogMessage)
            }
        )
    }
}


