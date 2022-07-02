package com.example.merybeltmobileapp.di.module

import androidx.room.Room
import com.example.merybeltmobileapp.Application
import com.example.merybeltmobileapp.provider.room.room_provider_domain.MerryBeltRoomDao
import com.example.merybeltmobileapp.provider.room.room_provider_domain.MerryBeltRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Dao{

    @Provides
    @Singleton
    fun provideDatabase(app: Application): MerryBeltRoomDatabase {
        return Room.databaseBuilder(
            app, MerryBeltRoomDatabase::class.java, MerryBeltRoomDatabase.DATABASE_NAME_MERRYBELT
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDao(db: MerryBeltRoomDatabase): MerryBeltRoomDao {
        return db.doa
    }

}
