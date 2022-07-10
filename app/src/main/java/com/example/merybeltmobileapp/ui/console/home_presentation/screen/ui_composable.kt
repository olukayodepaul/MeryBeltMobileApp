package com.example.merybeltmobileapp.ui.console.home_presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.merybeltmobileapp.theme.Blues
import com.example.merybeltmobileapp.R
import com.example.merybeltmobileapp.theme.Blu
import com.example.merybeltmobileapp.theme.Purple200
import com.example.merybeltmobileapp.theme.reds



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

