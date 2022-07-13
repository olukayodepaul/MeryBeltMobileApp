package com.example.merybeltmobileapp.provider.api.api_provider_data

import com.example.merybeltmobileapp.ui.console.home_data.console_dto.Banks
import com.example.merybeltmobileapp.ui.login.login_data.login_dto.LoginCredential
import com.example.merybeltmobileapp.ui.login.login_data.login_dto.LoginResponse
import retrofit2.Response
import retrofit2.http.*

interface MerryBeltApi {
    @POST("/merry/auth")
    suspend fun login(
        @Header("Request-Time")  requestTime: String,
        @Header("Api-Hash-Key")  apiHashKey: String,
        @Header("Api-User-Id")  apiUserId: Int,
        @Body data: LoginCredential
    ): Response<LoginResponse>

    @GET("/resd/banks")
    suspend fun getBanks(
        @Header("terminalId")  terminalId: String,
        @Header("sessionId")  sessionId: String,
    ): Response<Banks>
}