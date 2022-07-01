package com.example.merybeltmobileapp.provider.accesskey

interface AccesskeyDomain {
    suspend fun apiUserskey():String
    suspend fun apiUserLogin(): String
}