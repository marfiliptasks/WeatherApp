package com.mf.domain.repository

import com.mf.domain.models.weather.LocationWeatherEntity
import io.reactivex.Single

interface IWeatherRepository {
    fun getWeather(lat: Double, lon: Double, from: Long, to: Long): Single<LocationWeatherEntity>
}