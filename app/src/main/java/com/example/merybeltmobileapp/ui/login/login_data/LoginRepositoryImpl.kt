package com.example.merybeltmobileapp.ui.login.login_data

import com.example.merybeltmobileapp.provider.preference.PreferenceDomain
import com.example.merybeltmobileapp.ui.login.login_domain.LoginRepository
import javax.inject.Named

class LoginRepositoryImpl(
    private @Named("API_KEY") val apiKey: String,
    private @Named("API_USER_LOGIN") val apiUserLogin: String,
    private val preferens: PreferenceDomain
): LoginRepository{

}