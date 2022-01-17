package com.mf.domain.dataSource.weather

import com.mf.domain.models.weather.LocationWeatherEntity
import io.reactivex.Single

interface IWeatherRemoteDataSource {
    fun getWeather(locationKey: Double, lon: Double) : Single<LocationWeatherEntity>
}