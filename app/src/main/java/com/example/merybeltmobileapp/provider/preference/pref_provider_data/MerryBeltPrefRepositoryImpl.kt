package com.example.merybeltmobileapp.provider.preference.pref_provider_data

import android.content.SharedPreferences
import com.example.merybeltmobileapp.provider.preference.pref_provider_domain.MerryBeltPrefRepository

class MerryBeltPrefRepositoryImpl(
    private val sharedPref: SharedPreferences
): MerryBeltPrefRepository {

    override suspend fun saveShopName(shopname: String) {
        sharedPref.edit()
            .putString(MerryBeltPrefRepository.KEY_SHOP, shopname)
            .apply()
    }

    override suspend fun saveShopAddress(shopaddress: String) {
        sharedPref.edit()
            .putString(MerryBeltPrefRepository.KEY_ADDRESS, shopaddress)
            .apply()
    }

//    override suspend fun loadUserInfo(): UsersInfoDomain {
//        val age = sharedPref.getInt(MerryBeltPrefRepository.KEY_AGE, -1)
//        return UsersInfoDomain(
//            age = age,
//        )
//    }

}