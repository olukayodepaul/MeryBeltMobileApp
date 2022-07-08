package com.example.merybeltmobileapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationEvent
import com.example.merybeltmobileapp.ui.login.login_presentation.AuthenticationViewModel
import com.example.merybeltmobileapp.ui.login.login_presentation.component.ScreenThem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel: AuthenticationViewModel = hiltViewModel()
            val localContext = LocalContext.current
            val modifier: Modifier = Modifier
            val authenticationState = viewModel.uiState.collectAsState().value
            val handleEvent = viewModel::eventHandler

            //check if the screen state is login or home page.
            ScreenThem(
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

