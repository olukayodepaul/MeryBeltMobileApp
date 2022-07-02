package com.example.merybeltmobileapp.di.module

import com.example.merybeltmobileapp.provider.api.api_provider_data.MerryBeltApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModules {

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
        fun provideApi(client: OkHttpClient): MerryBeltApi {
            return Retrofit.Builder()
                .baseUrl("https://github.com/philipplackner/")
                .addConverterFactory(MoshiConverterFactory.create())
                .client(client)
                .build()
                .create(MerryBeltApi::class.java)
        }
     
}


