package com.example.merybeltmobileapp.provider.api.api_provider_data

//sealed class ApiState<out T> {
//    object Loading : ApiState<Nothing>()
//    data class Error(val throwable: Throwable? = null) : ApiState<Nothing>()
//    data class Success<out T>(val data: T? = null) : ApiState<T>()
//    object Empty : ApiState<Nothing>()
//}
//

sealed class ApiState {
    object Loading : ApiState()
    data class Success(val album: Int) : ApiState()
    data class Error(val throwable: String? = null): ApiState()
}
