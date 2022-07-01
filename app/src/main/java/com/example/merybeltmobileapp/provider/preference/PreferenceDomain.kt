package com.example.merybeltmobileapp.provider.preference

interface PreferenceDomain {

    fun saveAge(age: Int)
    fun loadUserInfo(): UsersInfoDomain

    companion object {
        const val KEY_AGE = "age"
    }

}