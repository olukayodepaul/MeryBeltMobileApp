package com.example.merybeltmobileapp.theme


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.merybeltmobileapp.R
import com.example.merybeltmobileapp.assets.Fonts
import com.example.merybeltmobileapp.util.isTransferLeadingIcon


@Composable
fun OutlinedTextFields(
    label: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    value:String,
    painter:Int=0,
    onValueChange:(String)->Unit,
) {

    val bColor = Borderline
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = keyboardOptions,
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
                    painter = painterResource(id = isTransferLeadingIcon(painter)),
                    contentDescription = label
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

@Composable
fun Buttons(
    label: String,
    onClick:()->Unit
) {
    Button(
        onClick = {

        },
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MChild
        ),

        ) {
        Text(
            text = label!!,
            style = TextStyle(
                color = White,
                fontSize = 20.sp,
                fontFamily = Fonts.MontserratBold
            ),
        )
    }
}




