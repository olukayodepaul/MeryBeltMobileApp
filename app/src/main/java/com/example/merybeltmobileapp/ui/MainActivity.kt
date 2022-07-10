package com.example.merybeltmobileapp.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.merybeltmobileapp.ui.login.login_presentation.AuthenticationViewModel
import com.example.merybeltmobileapp.ui.login.login_presentation.component.LoginScreenThem
import com.example.merybeltmobileapp.ui.navigation.setupNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var  viewModel: AuthenticationViewModel
    private lateinit var localContext: Context
    private lateinit var navHostController: NavHostController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            viewModel = hiltViewModel()
            localContext = LocalContext.current
            val authenticationState = viewModel.uiState.collectAsState().value
            val handleEvent = viewModel::eventHandler
            navHostController = rememberNavController()

            setupNavGraph(
                navController = navHostController,
                viewModel = viewModel,
                localContext = localContext,
                authenticationState = authenticationState,
                handleEvent = handleEvent
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(
) {

}

