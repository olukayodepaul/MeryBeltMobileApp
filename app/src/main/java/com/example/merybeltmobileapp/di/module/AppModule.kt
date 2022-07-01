package com.example.merybeltmobileapp.di.module

import com.example.merybeltmobileapp.provider.local.LocalDatabaseDTO
import com.example.merybeltmobileapp.provider.preference.PreferenceDomain
import com.example.merybeltmobileapp.provider.remore.RemoteData
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
    fun isAccessKeys(
        token: String,
        apiUserLogin: String,
        preferences: PreferenceDomain,
        remote: RemoteData,
        local:  LocalDatabaseDTO
    ): LoginRepository{
        return LoginRepositoryImpl(
            token, apiUserLogin, preferences, remote, local
        )
    }

}