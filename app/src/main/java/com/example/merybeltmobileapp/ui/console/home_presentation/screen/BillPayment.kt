package com.example.merybeltmobileapp.ui.console.home_presentation.screen

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.merybeltmobileapp.ui.console.home_data.ConsoleEvent
import com.example.merybeltmobileapp.ui.console.home_data.ConsoleState
import com.example.merybeltmobileapp.ui.console.home_presentation.ConsoleViewModel

@Composable
fun BillPaymentScreen(
    navHostControllers: NavHostController,
    localContext: Context,
    viewModel: ConsoleViewModel,
    consoleState: ConsoleState,
    consoleEventHandler: (ConsoleEvent)->Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Composable
@Preview
fun BillPaymentScreenPreview() {

}