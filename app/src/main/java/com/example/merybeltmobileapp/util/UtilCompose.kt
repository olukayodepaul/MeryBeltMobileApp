package com.example.merybeltmobileapp.util

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.merybeltmobileapp.R
import com.example.merybeltmobileapp.assets.Fonts
import com.example.merybeltmobileapp.theme.*
import com.example.merybeltmobileapp.ui.dto.Specimen
import com.example.merybeltmobileapp.ui.screen.navigation.Screen


object UtilCompose {

    @Composable
    fun UtilSpaceInBetween(unitOfMeasure: Int) {
        Spacer(modifier = Modifier.padding(bottom = unitOfMeasure.dp))
    }

    @Composable
    fun InputWidget(title: String, leadingIcon:Int) {
        // Outlined Text Input Field
        UtilSpaceInBetween(5)
        var isMutableStateOf by remember { mutableStateOf("") }

        val bColor = Borderline
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = isMutableStateOf,
            onValueChange = { isMutableStateOf = it },
            label = {
                Text(
                    text = title,
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
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = isTransferLeadingIcon(leadingIcon)),
                        contentDescription = title
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
                cursorColor = GreyTransparent
            )
        )
    }


    @Composable
    fun SpecimenSpinners(specimens: List<Specimen>, hint:String, leadingImageIcon: Int ) {

        UtilSpaceInBetween(5)

        var specimenText by remember { mutableStateOf("") }
        var expanded by remember { mutableStateOf(false) }
        val bColor = Borderline


        Box{
                OutlinedTextField(
                    value = (specimenText),
                    onValueChange = { },
                    label = {
                        Text(
                            text = hint,
                            style = TextStyle(
                                fontFamily = Fonts.Montserrat,
                                color = Blues,
                                fontSize = 18.sp
                            )
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = { Icon(Icons.Outlined.ArrowDropDown, null) },
                    readOnly = true,
                    shape = RoundedCornerShape(6.dp),
                    leadingIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = isTransferLeadingIcon(leadingImageIcon)),
                                contentDescription = ""
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
                        cursorColor = GreyTransparent
                    ),
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    Modifier.fillMaxWidth()
                ) {
                    specimens.forEach { specimen ->
                        DropdownMenuItem(onClick = {
                            expanded = false
                            specimenText = specimen.toString()
                        }) {
                            Text(text = specimen.toString())
                        }
                    }
                }
                Spacer(
                    modifier = Modifier
                        .matchParentSize()
                        .background(Color.Transparent)
                        .padding(10.dp)
                        .clickable(
                            onClick = { expanded = !expanded }
                        )
                )
            }
        }
    }

@Composable
fun isTransferLeadingIcon(switchImage: Int):Int {
    val drawables = arrayOf(
        R.drawable.ic_baseline_domain_add_24, R.drawable.ic_baseline_business_center_24, R.drawable.ic_baseline_swap_horiz_24,
        R.drawable.ic_baseline_payments_24, R.drawable.ic_baseline_payments_24, R.drawable.ic_baseline_sync_alt_24, R.drawable.ic_baseline_network_check_24,
        R.drawable.ic_baseline_add_card_24, R.drawable.ic_baseline_content_paste_search_24, R.drawable.ic_baseline_payment_24
    )
    return drawables[switchImage]
}

@Composable
fun SubmitButton(
    isContent:String?=null
) {
    Button(
        onClick = {
                  Log.d("EPOKHAI","cLICKING  ")
//                  navController!!.navigate(route = Screen.HomeScreen.route)
        },
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MChild
        ),

        ) {
        androidx.compose.material.Text(
            text = isContent!!,
            style = TextStyle(
                color = White,
                fontSize = 20.sp,
                fontFamily = Fonts.MontserratBold
            ),
        )
    }
}


@Composable
fun ScaffoldWithTopBar() {

}







