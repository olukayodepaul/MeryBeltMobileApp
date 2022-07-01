package com.example.merybeltmobileapp.di.module

import com.example.merybeltmobileapp.provider.preference.PreferenceDomain
import com.example.merybeltmobileapp.ui.login.login_data.LoginRepositoryImpl
import com.example.merybeltmobileapp.ui.login.login_domain.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun isAccesKeys(
        token: String,
        apiUserLogin: String,
        preferens: PreferenceDomain
    ): LoginRepository{
        return LoginRepositoryImpl(
            token, apiUserLogin, preferens
        )
    }

}