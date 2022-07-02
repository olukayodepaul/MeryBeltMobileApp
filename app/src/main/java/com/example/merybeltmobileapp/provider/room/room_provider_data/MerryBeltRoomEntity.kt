package com.example.merybeltmobileapp.provider.room.room_provider_data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "login")
data class Login (
    @PrimaryKey(autoGenerate = false)
    var auto: Int? = null
)
