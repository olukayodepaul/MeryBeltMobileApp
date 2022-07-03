package com.example.merybeltmobileapp.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.merybeltmobileapp.ui.login.login_presentation.loginUi
import com.example.merybeltmobileapp.ui.screen.navigation.setupNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            setupNavGraph(navController= navController)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenPreview(){

}

