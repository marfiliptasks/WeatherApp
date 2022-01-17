package com.mf.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mf.data.database.entities.weather.LocationWeatherData
import io.reactivex.Single


@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun cacheWeatherInfo(weather: LocationWeatherData)

    @Query("SELECT * FROM locationweatherdata where lat == :lat AND lon == :lon AND savedDate BETWEEN :from AND :to")
    fun getWeatherInfo(lat: Double, lon: Double, from: Long, to: Long): Single<LocationWeatherData>

}