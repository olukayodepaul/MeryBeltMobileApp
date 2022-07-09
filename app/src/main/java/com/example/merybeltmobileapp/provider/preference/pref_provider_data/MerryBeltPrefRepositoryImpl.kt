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

    override suspend fun saveCustomerId(customerId: Int) {
        sharedPref.edit()
            .putInt(MerryBeltPrefRepository.KEY_CUSTOMERID, customerId)
            .apply()
    }

    override suspend fun saveBalance(balance: Float) {
        sharedPref.edit()
            .putFloat(MerryBeltPrefRepository.KEY_BALANCE, balance)
            .apply()
    }

//    override suspend fun loadUserInfo(): UsersInfoDomain {
//        val age = sharedPref.getInt(MerryBeltPrefRepository.KEY_AGE, -1)
//        return UsersInfoDomain(
//            age = age,
//        )
//    }

}