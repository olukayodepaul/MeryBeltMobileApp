package com.example.merybeltmobileapp.ui.login.login_data


import com.example.merybeltmobileapp.provider.local.LocalDatabaseDTO
import com.example.merybeltmobileapp.provider.preference.PreferenceDomain
import com.example.merybeltmobileapp.provider.remore.RemoteData
import com.example.merybeltmobileapp.ui.login.login_domain.LoginRepository
import javax.inject.Named

class LoginRepositoryImpl(
    @Named("API_KEY") val apiKey: String,
    @Named("API_USER_LOGIN") val apiUserLogin: String,
    private val preferens: PreferenceDomain,
    private val  remote: RemoteData,
    private val local: LocalDatabaseDTO

): LoginRepository {


}