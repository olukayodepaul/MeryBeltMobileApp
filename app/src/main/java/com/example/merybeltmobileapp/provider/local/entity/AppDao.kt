package com.example.merybeltmobileapp.provider.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Login (
    @PrimaryKey(autoGenerate = false)
    var auto: Int? = null
)