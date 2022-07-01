package com.example.merybeltmobileapp.provider.accesskey

import com.example.merybeltmobileapp.di.module.Keys

class AccesskeyData(
    private val api: Keys
) : AccesskeyDomain {

    override suspend fun apiUserkey(): String {
        return api.isApiKey()
    }

    override suspend fun apiUserLogin(): String {
        return  api.apiUserLogin()
    }

}