package com.example.merybeltmobileapp.provider.accesskey

interface AccesskeyDomain {
    suspend fun apiUserkey():String
    suspend fun apiUserLogin(): String
}