package com.example.merybeltmobileapp.provider.preference.pref_provider_domain

import com.example.merybeltmobileapp.provider.preference.pref_provider_data.UsersInfoDomain

interface MerryBeltPrefRepository {

    suspend fun saveAge(age: Int)
    suspend fun loadUserInfo(): UsersInfoDomain

    companion object {
        const val KEY_AGE = "age"
    }
}


