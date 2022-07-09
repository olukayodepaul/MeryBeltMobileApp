package com.example.merybeltmobileapp.provider.api.api_provider_data

import com.example.merybeltmobileapp.provider.api.api_provider_domain.MerryBeltApiRepository
import com.example.merybeltmobileapp.provider.preference.pref_provider_domain.MerryBeltPrefRepository
import com.example.merybeltmobileapp.provider.room.room_provider_domain.MerryBeltRoomDao
import com.example.merybeltmobileapp.ui.login.login_data.login_dto.LoginCredential
import com.example.merybeltmobileapp.ui.login.login_data.login_dto.LoginResponse
import retrofit2.Response


class MerryBeltApiRepositoryImpl(

    private val merryBeltApi: MerryBeltApi,
    private val authKey: String,
    private val apiUser: String,
    private val merryBeltRoomDao: MerryBeltRoomDao,
    private val sharedPref: MerryBeltPrefRepository

) : MerryBeltApiRepository {

    override suspend fun login(
        requestTime: String,
        apiHashKey: String,
        apiUserId: Int,
        data: LoginCredential
    ): Response<LoginResponse> {
        return merryBeltApi.login(
            requestTime,
            apiHashKey,
            apiUserId,
            data
        )
    }

    override suspend fun token(): String {
        return authKey
    }

    override suspend fun apiUser(): String {
        return apiUser
    }

    override suspend fun saveShopName(shopname: String) {
        sharedPref.saveShopName(shopname)
    }

    override suspend fun saveShopAddress(shopaddress: String) {
        sharedPref.saveShopAddress(shopaddress)
    }

    override suspend fun saveCustomerId(customerId: Int) {
        sharedPref.saveCustomerId(customerId)
    }

    override suspend fun saveBalance(balance: Float) {
        sharedPref.saveBalance(balance)
    }


}