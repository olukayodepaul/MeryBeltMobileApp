package com.example.merybeltmobileapp.provider.api.api_provider_data

import com.example.merybeltmobileapp.ui.console.home_data.console_dto.*
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

    @POST("/resd/account-validation")
    suspend fun customerValidation(
        @Header("terminalId")  terminalId: String,
        @Header("sessionId")  sessionId: String,
        @Body data: CustomerValidation
    )

    @POST("/resd/transaction")
    suspend fun transferFun(
        @Header("terminalId")  terminalId: String,
        @Header("sessionId")  sessionId: String,
        @Body data: TransferFundReq
    )

    @POST("/resd/network-mgt")
    suspend fun networkMgt(
        @Body data: NetworkMgtReq
    ): Response<NetworkMgtRes>

}