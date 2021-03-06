package com.example.merybeltmobileapp.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.merybeltmobileapp.ui.console.home_presentation.ConsoleViewModel
import com.example.merybeltmobileapp.ui.login.login_presentation.AuthenticationViewModel
import com.example.merybeltmobileapp.ui.graph.setupNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var  viewModel: AuthenticationViewModel
    private lateinit var  consoleViewModel: ConsoleViewModel
    private lateinit var localContext: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            viewModel = hiltViewModel()
            consoleViewModel = hiltViewModel()
            localContext = LocalContext.current
            val authenticationState = viewModel.uiState.collectAsState().value
            val consoleState = consoleViewModel.uiState.collectAsState().value
            val handleEvent = viewModel::authEventHandler
            val consoleEvent = consoleViewModel::consoleEventHandler
            val navHostController = rememberNavController()


            setupNavGraph(
                navController = navHostController,
                viewModel = viewModel,
                consoleViewModel = consoleViewModel,
                localContext = localContext,
                authenticationState = authenticationState,
                handleEvent = handleEvent,
                consoleState = consoleState,
                consoleEvent = consoleEvent
            )


        }
    }
}

