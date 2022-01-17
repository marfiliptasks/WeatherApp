package com.mf.domain.models.weather

import java.util.*

data class WeatherInfoEntity(
    val clouds: Double,
    val dewPoint: Double,
    val dt: Date,
    val feelsLike: FeelsLikeEntity,
    val humidity: Double,
    val pop: Double,
    val pressure: Double,
    val rain: Double,
    val snow: Double,
    val sunrise: Date,
    val sunset: Date,
    val temp: TempEntity,
    val uvi: Double,
    val weather: List<WeatherEntity>,
    val windDeg: Double,
    val windSpeed: Double
)