package com.example.merybeltmobileapp.provider.preference

interface PreferenceDomain {

    suspend fun saveAge(age: Int)
    suspend fun loadUserInfo(): UsersInfoDomain

    companion object {
        const val KEY_AGE = "age"
    }

}