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

    override suspend fun saveCustomerId(customerId: String) {
        sharedPref.edit()
            .putString(MerryBeltPrefRepository.KEY_CUSTOMERID, customerId)
            .apply()
    }

    override suspend fun saveBalance(balance: String) {
        sharedPref.edit()
            .putString(MerryBeltPrefRepository.KEY_BALANCE, balance)
            .apply()
    }

    override suspend fun loadUserInfo(): UsersInfoDomain {
        val customerId = sharedPref.getString(MerryBeltPrefRepository.KEY_CUSTOMERID, "0121999039")
        val balance = sharedPref.getString(MerryBeltPrefRepository.KEY_BALANCE, "3,569.00")
        return UsersInfoDomain(
            customerId = customerId!!,
            balance = balance!!
        )
    }

}