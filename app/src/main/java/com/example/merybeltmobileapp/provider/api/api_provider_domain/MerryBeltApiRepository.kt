package com.example.merybeltmobileapp.provider.api.api_provider_domain

import com.example.merybeltmobileapp.provider.preference.pref_provider_data.UsersInfoDomain
import com.example.merybeltmobileapp.ui.console.home_data.console_dto.Banks
import com.example.merybeltmobileapp.ui.console.home_data.console_dto.NetworkMgtReq
import com.example.merybeltmobileapp.ui.console.home_data.console_dto.NetworkMgtRes
import com.example.merybeltmobileapp.ui.login.login_data.login_dto.LoginCredential
import com.example.merybeltmobileapp.ui.login.login_data.login_dto.LoginResponse
import retrofit2.Response

interface MerryBeltApiRepository {

    suspend fun login(
        requestTime: String,
        apiHashKey: String,
        apiUserId: Int,
        data: LoginCredential,
    ): Response<LoginResponse>

    suspend fun token(): String

    suspend fun apiUser(): String

    suspend fun apiID(): Int

    suspend fun saveShopName(shopname: String)

    suspend fun saveShopAddress(shopaddress: String)

    suspend fun saveCustomerId(customerId: String)

    suspend fun saveBalance(balance: String)

    suspend fun loadUserInfo(): UsersInfoDomain

    suspend fun getBankList(terminalId: String, sessionId: String): Response<Banks>

    suspend fun networkMgt(data: NetworkMgtReq) : Response<NetworkMgtRes>

}