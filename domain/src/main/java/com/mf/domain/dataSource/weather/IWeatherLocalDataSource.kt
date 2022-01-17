package com.mf.domain.dataSource.weather

import com.mf.domain.models.weather.LocationWeatherEntity
import io.reactivex.Single

interface IWeatherLocalDataSource {
    fun getWeather(lat: Double, lon: Double, from: Long, to: Long): Single<LocationWeatherEntity>
    fun cacheWeatherResponse(weather: LocationWeatherEntity)
}