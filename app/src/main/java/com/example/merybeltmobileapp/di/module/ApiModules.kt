package com.example.merybeltmobileapp.di.module

import com.example.merybeltmobileapp.BuildConfig
import com.example.merybeltmobileapp.provider.api.api_provider_data.MerryBeltApi
import com.example.merybeltmobileapp.util.BasicAuthInterceptor
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModules {

    @Singleton
    @Provides
    fun provideApi(): MerryBeltApi {

        val supportInterceptor = BasicAuthInterceptor(
            username = "restdevice",
            password = "5NDM1NjckJV4KK"
        )

        val okHttpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .followRedirects(true)
            .followSslRedirects(true)
            .addInterceptor(supportInterceptor)

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addInterceptor(logging)
        }

        return Retrofit.Builder()
            .baseUrl("https://service-dev.trylux.africa")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(okHttpClientBuilder.build())
            .build()
            .create(MerryBeltApi::class.java)
    }


}


