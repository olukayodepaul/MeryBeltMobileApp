package com.example.merybeltmobileapp.provider.preference

import android.content.SharedPreferences

class DefaultPreferencesData(
    private val sharedPref: SharedPreferences
): PreferenceDomain {

    override fun saveAge(age: Int) {
        sharedPref.edit()
            .putInt(PreferenceDomain.KEY_AGE, age)
            .apply()
    }

    override fun loadUserInfo(): UsersInfoDomain {
        val age = sharedPref.getInt(PreferenceDomain.KEY_AGE, -1)
        return UsersInfoDomain(
            age = age,
        )
    }

}