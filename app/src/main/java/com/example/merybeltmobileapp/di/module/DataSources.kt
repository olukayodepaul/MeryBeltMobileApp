package com.example.merybeltmobileapp.di.module

import android.app.Application
import androidx.room.Room
import com.example.merybeltmobileapp.provider.local.LocalDatabase
import com.example.merybeltmobileapp.provider.local.LocalDatabaseDTO
import com.example.merybeltmobileapp.provider.remore.RemoteData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.create


@Module
@InstallIn(SingletonComponent::class)
class DataSources {


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(client: OkHttpClient): RemoteData {
        return Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application): LocalDatabase {
        return Room.databaseBuilder(app, LocalDatabase::class.java, "tracker_db").build()
    }

    @Provides
    @Singleton
    fun provideDao(db: LocalDatabase): LocalDatabaseDTO {
        return db.dao
    }

}