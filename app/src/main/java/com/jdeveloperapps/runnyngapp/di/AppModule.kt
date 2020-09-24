package com.jdeveloperapps.runnyngapp.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.jdeveloperapps.runnyngapp.db.RunningDatabase
import com.jdeveloperapps.runnyngapp.other.Constans.KEY_FIRST_TIME_TOGGLE
import com.jdeveloperapps.runnyngapp.other.Constans.KEY_NAME
import com.jdeveloperapps.runnyngapp.other.Constans.KEY_WEIGHT
import com.jdeveloperapps.runnyngapp.other.Constans.RUNNING_DATABASE_NAME
import com.jdeveloperapps.runnyngapp.other.Constans.SHARED_PREFERENCE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRunningDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideRunDao(db: RunningDatabase) = db.getRunDao()

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext app: Context) =
        app.getSharedPreferences(SHARED_PREFERENCE_NAME, MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideName(sharedPref: SharedPreferences) = sharedPref.getString(KEY_NAME, "") ?: ""

    @Singleton
    @Provides
    fun provideWeight(sharedPref: SharedPreferences) = sharedPref.getFloat(KEY_WEIGHT, 80f)

    @Singleton
    @Provides
    fun provideFirstTimeToggle(sharedPref: SharedPreferences) = sharedPref.getBoolean(
        KEY_FIRST_TIME_TOGGLE, true)
}