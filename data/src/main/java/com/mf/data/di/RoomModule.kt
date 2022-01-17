package com.mf.data.di

import android.content.Context
import androidx.room.Room
import com.mf.data.database.AppDatabase
import com.mf.data.database.daos.LocationDao
import com.mf.data.database.daos.QueryDao
import com.mf.data.database.daos.WeatherDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {
    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext appContext: Context) = Room.databaseBuilder(
        appContext,
        AppDatabase::class.java,
        "weatherapp.db"
    ).build()


    @Provides
    fun provideQueryDao(database: AppDatabase): QueryDao = database.queryDao()

    @Provides
    fun provideLocationDao(database: AppDatabase): LocationDao = database.locationDao()

    @Provides
    fun provideWeathernDao(database: AppDatabase): WeatherDao = database.weatherDao()
}