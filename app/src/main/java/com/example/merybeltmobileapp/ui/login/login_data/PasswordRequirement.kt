package com.example.merybeltmobileapp.ui.login.login_data

import androidx.annotation.StringRes
import com.example.merybeltmobileapp.R

enum class PasswordRequirement(
    @StringRes val label: Int
) {
    CAPITAL_LETTER(R.string.password_requirement_capital),
    NUMBER(R.string.password_requirement_characters),
    EIGHT_CHARACTERS(R.string.password_requirement_digit)
}