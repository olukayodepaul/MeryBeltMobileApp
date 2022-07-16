package com.example.merybeltmobileapp.ui.login.login_presentation.auth_component


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.merybeltmobileapp.assets.Fonts
import com.example.merybeltmobileapp.theme.MChild
import com.example.merybeltmobileapp.theme.White
import com.example.merybeltmobileapp.ui.AuthScreen
import com.example.merybeltmobileapp.ui.graph.Graph
import com.example.merybeltmobileapp.ui.login.login_data.AuthenticationState
import com.example.merybeltmobileapp.ui.login.login_presentation.AuthenticationViewModel


@Composable
fun AuthenticationButtons(
    title:String = "",
    viewModel: AuthenticationViewModel,
    uiState: AuthenticationState,
    navHostControllers: NavHostController,
) {
    Button(
        onClick = {
            navHostControllers.navigate(route = Graph.HOME)
            {
                popUpTo(route = AuthScreen.Login.route) {
                    inclusive = true
                }
            }
            //viewModel.AuthApiRequest(uiState.username, uiState.password)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MChild
        ),
    ) {
        Text(
            text = title,
            style = TextStyle(
                color = White,
                fontSize = 20.sp,
                fontFamily = Fonts.MontserratBold
            ),
        )
    }
}

