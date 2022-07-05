package com.example.merybeltmobileapp.provider.api.api_provider_domain

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

    suspend fun saveShopName(shopname: String)

    suspend fun saveShopAddress(shopaddress: String)

}