package com.example.merybeltmobileapp.ui.login.login_presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.merybeltmobileapp.assets.Fonts
import com.example.merybeltmobileapp.theme.Blues
import com.example.merybeltmobileapp.theme.Borderline
import com.example.merybeltmobileapp.theme.GreyTransparent


@Composable
fun InputForms(
    username: String,
    onValueChange: (String) -> Unit,
    label:String = "",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {

    val bColor = Borderline

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        value = username,
        onValueChange = {username->
            onValueChange(username)
        },
        keyboardOptions = keyboardOptions.copy(keyboardType = KeyboardType.Text),
        visualTransformation = visualTransformation,
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
        maxLines = 1,
        shape = RoundedCornerShape(6.dp),
        leadingIcon = {
            IconButton(onClick = {

            }) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            }
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
        )
    )
}