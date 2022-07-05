package com.example.merybeltmobileapp.util

import retrofit2.Response

sealed class NetworkResult<out T> {
    //object Loading : NetworkResult<Nothing>()
    data class Error(val throwable: Throwable? = null) : NetworkResult<Nothing>()
    data class Failure<out T>(val data: T? = null) : NetworkResult<Nothing>()
    data class Success<out T>(val data: T? = null) : NetworkResult<T>()
    object Empty : NetworkResult<Nothing>()
}

sealed class APIResponse<out T>{
    class Success<T>(response: Response<T>): APIResponse<T>() {
        val data = response
    }
    class Failure<T>(response: Response<T>): APIResponse<T>() {
        val message:String = response.errorBody().toString()
    }
    class Exception<T>(throwable: Throwable): APIResponse<T>() {
        val message:String? = throwable.localizedMessage
    }
    object Empty : APIResponse<Nothing>()
}

