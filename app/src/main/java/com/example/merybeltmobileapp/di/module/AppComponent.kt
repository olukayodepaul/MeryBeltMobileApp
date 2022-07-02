package com.example.merybeltmobileapp.di.module

import android.content.Context
import com.example.merybeltmobileapp.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppComponent {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): Application {
        return app as Application
    }

}