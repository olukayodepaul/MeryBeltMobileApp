package com.example.merybeltmobileapp.ui.login.login_presentation.component


import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.merybeltmobileapp.R

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
                    Text(text = "Close")
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


