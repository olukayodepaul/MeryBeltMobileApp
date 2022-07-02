package com.example.merybeltmobileapp.di.module


//@Module
//@InstallIn(SingletonComponent::class)
//class PreferenceModule {
//
//    @Provides
//    @Singleton
//    fun provideSharedPreferences(app: Application): SharedPreferences {
//        return app.getSharedPreferences("shared_pref", MODE_PRIVATE)
//    }
//
//    @Provides
//    @Singleton
//    fun providePreferences(sharedPreferences: SharedPreferences): PreferenceDomain {
//        return DefaultPreferencesData(sharedPreferences)
//    }
//
//}