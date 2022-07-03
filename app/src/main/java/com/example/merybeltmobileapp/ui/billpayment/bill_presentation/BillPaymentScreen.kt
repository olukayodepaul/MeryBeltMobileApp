package com.example.merybeltmobileapp.ui.billpayment.bill_presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.merybeltmobileapp.assets.Fonts.Montserrat
import com.example.merybeltmobileapp.assets.Fonts.MontserratBold
import com.example.merybeltmobileapp.assets.Fonts.RobotoBold
import com.example.merybeltmobileapp.theme.MChild
import com.example.merybeltmobileapp.theme.MaterialBg
import com.example.merybeltmobileapp.theme.White
import com.example.merybeltmobileapp.ui.dto.Specimen
import com.example.merybeltmobileapp.util.SubmitButton
import com.example.merybeltmobileapp.util.UtilCompose.InputWidget
import com.example.merybeltmobileapp.util.UtilCompose.SpecimenSpinners
import com.example.merybeltmobileapp.util.UtilCompose.UtilSpaceInBetween



@Composable
fun MainSreen(){
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Data, Airtime and Bill Payment",
                            style = TextStyle(
                                fontFamily = MontserratBold,
                                fontSize = 15.sp,

                                )
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.ArrowBack,"backIcon", tint = White)
                        }
                    },
                    backgroundColor = MChild,
                    contentColor = Color.White,
                    elevation = 12.dp
                )
            }, content = {
                Column(Modifier
                    .fillMaxSize()
                ) {

                    Column(
                        Modifier
                            .background(MaterialBg)
                            .padding(20.dp)
                    ) {



                        Text(
                            text = "Select a category",
                            style = TextStyle(
                                fontFamily = RobotoBold,
                                fontSize = 18.sp
                            )
                        )

                        UtilSpaceInBetween(4)

                        Text(
                            text = "Your airtime and data top up, cable tv and internet payment ",
                            style = TextStyle(
                                fontFamily = Montserrat,
                                fontSize = 13.sp
                            )
                        )

                        val specimen = ArrayList<Specimen>()
                        specimen.add(Specimen(plantName = "Airtime"))
                        specimen.add(Specimen(plantName = "Data"))
                        specimen.add(Specimen(plantName = "Cable Tv"))
                        specimen.add(Specimen(plantName = "Internet"))

                        SpecimenSpinners(specimen, "", 5)

                        UtilSpaceInBetween(5)
                    }

                    //here
                }

            }
        )
    }
}



@Composable
fun loadData(){

    val specimen = ArrayList<Specimen>()
    specimen.add(Specimen(plantName = "Airtime"))
    specimen.add(Specimen(plantName = "Data"))
    specimen.add(Specimen(plantName = "Cable Tv"))
    specimen.add(Specimen(plantName = "Internet"))

    Column(

        Modifier
            .fillMaxSize()
            .background(White)
            .padding(20.dp)
    ) {
        Text(
            text = "Load Internet Data",
            style = TextStyle(
                fontFamily = Montserrat,
                fontSize = 18.sp,
                textDecoration = TextDecoration.Underline,
                color = MChild
            )
        )

        UtilSpaceInBetween(5)

        SpecimenSpinners(specimen, "Select Network", 6)
        SpecimenSpinners(specimen, "Select Bundle", 7)
        InputWidget("Phone Number", 8)
        UtilSpaceInBetween(10)
        SubmitButton("Next")

    }
}

@Composable
fun cableTv(){

    val specimen = ArrayList<Specimen>()
    specimen.add(Specimen(plantName = "Airtime"))
    specimen.add(Specimen(plantName = "Data"))
    specimen.add(Specimen(plantName = "Cable Tv"))
    specimen.add(Specimen(plantName = "Internet"))

    Column(

        Modifier
            .fillMaxSize()
            .background(White)
            .padding(20.dp)
    ) {
        Text(
            text = "Your Cable Tv Bill Payment",
            style = TextStyle(
                fontFamily = Montserrat,
                fontSize = 18.sp,
                textDecoration = TextDecoration.Underline,
                color = MChild
            )
        )

        UtilSpaceInBetween(5)
        SpecimenSpinners(specimen, "Select Your Provider", 6)
        SpecimenSpinners(specimen, "Select Bundle", 7)
        InputWidget("Smart Card Provider", 8)
        UtilSpaceInBetween(10)
        SubmitButton("Next")

    }
}


@Composable
fun internetService(){

    val specimen = ArrayList<Specimen>()
    specimen.add(Specimen(plantName = "Airtime"))
    specimen.add(Specimen(plantName = "Data"))
    specimen.add(Specimen(plantName = "Cable Tv"))
    specimen.add(Specimen(plantName = "Internet"))

    Column(

        Modifier
            .fillMaxSize()
            .background(White)
            .padding(20.dp)
    ) {
        Text(
            text = "Your Internet Service Provider",
            style = TextStyle(
                fontFamily = Montserrat,
                fontSize = 18.sp,
                textDecoration = TextDecoration.Underline,
                color = MChild
            )
        )

        UtilSpaceInBetween(5)
        SpecimenSpinners(specimen, "Select Your Provider", 6)
        SpecimenSpinners(specimen, "Select Bundle", 7)
        InputWidget("Account Number", 8)
        UtilSpaceInBetween(10)
        SubmitButton("Next")

    }
}

@Composable
fun airtimeTopUp(){

    val specimen = ArrayList<Specimen>()
    specimen.add(Specimen(plantName = "Airtime"))
    specimen.add(Specimen(plantName = "Data"))
    specimen.add(Specimen(plantName = "Cable Tv"))
    specimen.add(Specimen(plantName = "Internet"))

    Column(

        Modifier
            .fillMaxSize()
            .background(White)
            .padding(20.dp)
    ) {
        Text(
            text = "Your Airtime Top-Up",
            style = TextStyle(
                fontFamily = Montserrat,
                fontSize = 18.sp,
                textDecoration = TextDecoration.Underline,
                color = MChild
            )
        )

        InputWidget("Phone Number", 8)
        InputWidget("Amount", 9)
        UtilSpaceInBetween(10)
        SubmitButton("Next")

    }
}