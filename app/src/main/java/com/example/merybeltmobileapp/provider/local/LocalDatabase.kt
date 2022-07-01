package com.example.merybeltmobileapp.provider.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.merybeltmobileapp.provider.local.entity.Login


@Database(
    entities = [Login::class],
    version = 1,
    exportSchema = false
)
abstract class  LocalDatabase: RoomDatabase() {
    abstract val dao: LocalDatabaseDTO
}