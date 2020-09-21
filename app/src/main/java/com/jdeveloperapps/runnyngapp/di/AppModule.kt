package com.jdeveloperapps.runnyngapp.di

import android.content.Context
import androidx.room.Room
import com.jdeveloperapps.runnyngapp.db.RunningDatabase
import com.jdeveloperapps.runnyngapp.other.Constans.RUNNING_DATABASE_NAME
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
    fun prpvideRunDao(db: RunningDatabase) = db.getRunDao()
}