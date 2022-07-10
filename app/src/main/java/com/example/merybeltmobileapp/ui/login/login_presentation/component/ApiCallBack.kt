package com.example.merybeltmobileapp.ui.login.login_presentation.component

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import com.example.merybeltmobileapp.ui.login.login_data.ApiState

@Composable
fun AuthenticationApiCallBack(
    apiState: ApiState,
    local: Context
){
    when(apiState){
        is ApiState.Error->{
            Toast.makeText(local, "Error", Toast.LENGTH_SHORT).show()
        }
        is ApiState.Loading->{
            Toast.makeText(local, "Loading", Toast.LENGTH_SHORT).show()
        }
        is ApiState.Success->{
            Toast.makeText(local, "Success", Toast.LENGTH_SHORT).show()
        }
    }
}