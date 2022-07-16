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
    ): Response<Banks> //bank List

    @POST("/resd/account-validation")
    suspend fun customerValidation(
        @Header("terminalId")  terminalId: String,
        @Header("sessionId")  sessionId: String,
        @Body data: CustomerValidation //cust validation
    )

    @POST("/resd/transaction")
    suspend fun transferFun(
        @Header("terminalId")  terminalId: String,
        @Header("sessionId")  sessionId: String,
        @Body data: TransferFundReq
    ): Response<TransferFundRes> //Transfer fun

    @POST("/resd/network-mgt")
    suspend fun networkMgt(
        @Body data: NetworkMgtReq
    ): Response<NetworkMgtRes> //Network

    @POST("/resd/transaction")
    suspend fun airTime(
        @Header("terminalId")  terminalId: String,
        @Header("sessionId")  sessionId: String,
        @Body data: AirtimeReq
    ): Response<AirtimeBodyData> //Airtime

    @POST("/resd/transaction")
    suspend fun cableTv(
        @Header("terminalId")  terminalId: String,
        @Header("sessionId")  sessionId: String,
        @Body data: CableTvReq
    ): Response<CableTvBodyData> //Cable Tv

    @POST("/resd/transaction")
    suspend fun getPhcn(
        @Header("terminalId")  terminalId: String,
        @Header("sessionId")  sessionId: String,
        @Body data: PhcnReq
    ): Response<PhcnBodyData> //Phcn


}