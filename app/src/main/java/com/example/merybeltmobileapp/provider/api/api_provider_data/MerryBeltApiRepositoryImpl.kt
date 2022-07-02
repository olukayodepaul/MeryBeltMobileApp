package com.example.merybeltmobileapp.provider.api.api_provider_data

import com.example.merybeltmobileapp.provider.api.api_provider_domain.MerryBeltApiRepository
import com.example.merybeltmobileapp.provider.preference.pref_provider_domain.MerryBeltPrefRepository
import com.example.merybeltmobileapp.provider.room.room_provider_domain.MerryBeltRoomDao


class MerryBeltApiRepositoryImpl(
    private val merryBeltApi: MerryBeltApi,
    private val authKey: String,
    private val apiUser: String,
    private val merryBeltRoomDao: MerryBeltRoomDao,
    private val sharedPref: MerryBeltPrefRepository
): MerryBeltApiRepository {

    override suspend fun login(): Int {
        return merryBeltApi.login()
    }

    override suspend fun token(): String {
        return authKey
    }

    override suspend fun apiUser(): String {
        return apiUser
    }

}