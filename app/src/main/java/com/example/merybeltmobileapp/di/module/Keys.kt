package com.example.merybeltmobileapp.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Keys {

    @Provides
    @Singleton
    @Named("API_KEY")
    fun isApiKey(): String {
       return "6a7941634d54705a4d6a346a53714461347274664d42475048"
    }

    @Provides
    @Singleton
    @Named("API_USER_LOGIN")
    fun apiUserLogin() : String {
        return "external-user"
    }

}