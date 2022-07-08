package com.example.merybeltmobileapp.ui.login.login_presentation.component


import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import com.example.merybeltmobileapp.ui.login.login_data.login_dto.dialogMapper


@Composable
fun AuthenticationErrorDialogs (
    isDialogShow : Boolean,
    isDialogMessage: String,
    isDialogTitle: String = "",
) {
    if(isDialogShow)
    {
        AlertDialog(
            onDismissRequest = {
                isDialogShow
            },
            confirmButton = {
                TextButton(onClick = {
                    isDialogShow
                })
                { Text(text = "Close") }
            },
            title = { Text(text = isDialogTitle) },
            text = { Text(text = isDialogMessage) }
        )

    }
}


