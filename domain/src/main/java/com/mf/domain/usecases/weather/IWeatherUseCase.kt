package com.mf.domain.usecases.weather

import com.mf.domain.models.weather.LocationWeatherEntity
import io.reactivex.Single

interface IWeatherUseCase {
    fun getWeather(
        lat: Double,
        lon: Double,
        from: Long,
        to: Long
    ): Single<LocationWeatherEntity>
}