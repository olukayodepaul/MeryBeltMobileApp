package com.example.merybeltmobileapp.provider.api.api_provider_domain

interface MerryBeltApiRepository {
    suspend fun login(): Int
    suspend fun token():String
    suspend fun apiUser(): String
}