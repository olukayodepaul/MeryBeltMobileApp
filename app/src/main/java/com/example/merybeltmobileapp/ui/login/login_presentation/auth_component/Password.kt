package com.example.merybeltmobileapp.ui.login.login_presentation.auth_component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.merybeltmobileapp.R
import com.example.merybeltmobileapp.assets.Fonts
import com.example.merybeltmobileapp.theme.Blues
import com.example.merybeltmobileapp.theme.Borderline
import com.example.merybeltmobileapp.theme.GreyTransparent

@Composable
fun PasswordFields (
    username: String,
    onValueChange: (String) -> Unit,
    label:String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    var isPasswordHidden by remember {
        mutableStateOf(true)
    }

    val bColor = Borderline

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        value = username,
        onValueChange = {password->
            onValueChange(password)
        },
        keyboardOptions = keyboardOptions.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        singleLine = true,
        label = {
            Text(
                text = label,
                style = TextStyle(
                    fontFamily = Fonts.Montserrat,
                    color = Blues,
                    fontSize = 18.sp
                )
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null
            )
        },
        trailingIcon = {
            Icon(
                modifier = Modifier.clickable(
                    onClickLabel = if (isPasswordHidden) {
                        stringResource(id = R.string.cd_show_password)
                    } else stringResource(id = R.string.cd_hide_password)
                ) {
                    isPasswordHidden = !isPasswordHidden
                },
                painter = if (isPasswordHidden) {
                    painterResource(R.drawable.ic_baseline_visibility_24)
                } else painterResource(R.drawable.ic_baseline_visibility_off_24),
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color(
                bColor.red, bColor.green, bColor.blue,
                TextFieldDefaults.BackgroundOpacity
            ),
            focusedBorderColor = bColor,
            unfocusedBorderColor = Color(
                bColor.red, bColor.green, bColor.blue,
                TextFieldDefaults.UnfocusedIndicatorLineOpacity,
            ),
            focusedLabelColor = GreyTransparent,
            cursorColor = GreyTransparent,
        ),
        maxLines = 1,
        shape = RoundedCornerShape(6.dp),
    )
}
