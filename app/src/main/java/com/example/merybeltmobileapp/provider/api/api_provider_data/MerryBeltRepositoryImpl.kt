package com.example.merybeltmobileapp.provider.api.api_provider_data

import com.example.merybeltmobileapp.provider.api.api_provider_domain.MerryBeltRepository


class MerryBeltRepositoryImpl(
    private val merryBeltApi: MerryBeltApi,
    private val authKey: String,
    private val apiUser: String
): MerryBeltRepository {

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