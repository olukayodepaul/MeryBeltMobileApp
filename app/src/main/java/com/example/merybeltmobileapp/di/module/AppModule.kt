package com.example.merybeltmobileapp.di.module


import com.example.merybeltmobileapp.provider.api.api_provider_data.MerryBeltApi
import com.example.merybeltmobileapp.provider.api.api_provider_data.MerryBeltRepositoryImpl
import com.example.merybeltmobileapp.provider.api.api_provider_domain.MerryBeltRepository
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
    fun provideMerrybeltRepository(
        merryBeltApi: MerryBeltApi,
        @Named("TOKEN_KEY") authToken: String,
        @Named("API_USER_LOGIN") apiUser: String,
        merryBeltRoomDao: MerryBeltRoomDao
    ): MerryBeltRepository{
        return MerryBeltRepositoryImpl(
            merryBeltApi, authToken, apiUser, merryBeltRoomDao
        )
    }


}