package com.example.merybeltmobileapp.provider.api.api_provider_data

import retrofit2.http.GET

interface MerryBeltApi {

    @GET("")
    suspend fun login(): Int
}