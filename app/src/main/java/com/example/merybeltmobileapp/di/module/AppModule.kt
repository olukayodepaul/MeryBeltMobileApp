package com.example.merybeltmobileapp.di.module


import android.content.SharedPreferences
import com.example.merybeltmobileapp.provider.api.api_provider_data.MerryBeltApi
import com.example.merybeltmobileapp.provider.api.api_provider_data.MerryBeltApiRepositoryImpl
import com.example.merybeltmobileapp.provider.api.api_provider_domain.MerryBeltApiRepository
import com.example.merybeltmobileapp.provider.preference.pref_provider_data.MerryBeltPrefRepositoryImpl
import com.example.merybeltmobileapp.provider.preference.pref_provider_domain.MerryBeltPrefRepository
import com.example.merybeltmobileapp.provider.room.room_provider_domain.MerryBeltRoomDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMerryBeltPrefRepository(
        sharedPref: SharedPreferences
    ): MerryBeltPrefRepository {
        return MerryBeltPrefRepositoryImpl(
            sharedPref
        )
    }

    @Provides
    @Singleton
    fun provideMerrybeltRepository(
        merryBeltApi: MerryBeltApi,
        @Named("TOKEN_KEY") authToken: String,
        @Named("API_USER_LOGIN") apiUser: String,
        apiId: Int,
        merryBeltRoomDao: MerryBeltRoomDao,
        merryPref: MerryBeltPrefRepository
    ): MerryBeltApiRepository{
        return MerryBeltApiRepositoryImpl(
            merryBeltApi, authToken, apiUser, apiId, merryBeltRoomDao, merryPref
        )
    }

}