package com.example.merybeltmobileapp.provider.datastore

interface UserPreferencesRepository {
    suspend fun setName(name: String)
    suspend fun getName(): Result<String>
}