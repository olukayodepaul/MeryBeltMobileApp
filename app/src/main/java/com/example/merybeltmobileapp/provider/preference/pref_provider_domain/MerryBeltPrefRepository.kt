package com.example.merybeltmobileapp.provider.preference.pref_provider_domain

import com.example.merybeltmobileapp.provider.preference.pref_provider_data.UsersInfoDomain

interface MerryBeltPrefRepository {

    suspend fun saveShopName(shopname: String)
    suspend fun saveShopAddress(shopaddress: String)
    //suspend fun loadUserInfo(): UsersInfoDomain

    companion object {
        const val KEY_SHOP = "shopname"
        const val KEY_ADDRESS = "shopaddress"
    }
}


