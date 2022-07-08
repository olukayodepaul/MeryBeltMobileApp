package com.example.merybeltmobileapp.ui.login.login_presentation.component


import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable


@Composable
fun AuthenticationErrorDialogs (
    status : Boolean,
    message: String,
    title: String = "",
) {
    if(status)
    {
        AlertDialog(
            onDismissRequest = {
                status
            },
            confirmButton = {
                TextButton(onClick = {
                    status
                })
                { Text(text = "Close") }
            },
            title = { Text(text = "Please confirm") },
            text = { Text(text = "Should I continue with the requested action?") }
        )

    }
}


