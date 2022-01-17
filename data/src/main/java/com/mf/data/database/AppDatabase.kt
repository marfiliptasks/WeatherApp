package com.mf.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mf.data.database.converters.LocationWeatherConverters
import com.mf.data.database.daos.LocationDao
import com.mf.data.database.daos.QueryDao
import com.mf.data.database.daos.WeatherDao
import com.mf.data.database.entities.location.LocationData
import com.mf.data.database.entities.QueryData
import com.mf.data.database.entities.weather.LocationWeatherData

@Database(
    version = 1,
    entities = [
        QueryData::class,
        LocationData::class,
        LocationWeatherData::class
    ]
)
@TypeConverters(LocationWeatherConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun queryDao(): QueryDao
    abstract fun locationDao(): LocationDao
    abstract fun weatherDao() : WeatherDao
}