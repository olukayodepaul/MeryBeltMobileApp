package com.example.merybeltmobileapp.theme

import androidx.compose.runtime.Composable
import com.example.merybeltmobileapp.R

@Composable
fun cusIcon(switchImage: Int):Int {
    val drawables = arrayOf(
        R.drawable.ic_baseline_domain_add_24, R.drawable.ic_baseline_business_center_24, R.drawable.ic_baseline_swap_horiz_24,
        R.drawable.ic_baseline_payments_24, R.drawable.ic_baseline_payments_24, R.drawable.ic_baseline_sync_alt_24, R.drawable.ic_baseline_network_check_24,
        R.drawable.ic_baseline_add_card_24, R.drawable.ic_baseline_content_paste_search_24, R.drawable.ic_baseline_payment_24
    )
    return drawables[switchImage]
}