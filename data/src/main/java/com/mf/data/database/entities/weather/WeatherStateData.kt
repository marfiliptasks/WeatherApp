package com.mf.data.database.entities.weather

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class WeatherStateData(
    val clouds: Double,
    val dewPoint: Double,
    val dt: Date,
    val feelsLike: FeelsLikeData,
    val humidity: Double,
    val pop: Double,
    val pressure: Double,
    val rain: Double,
    val snow: Double,
    val sunrise: Date,
    val sunset: Date,
    val temp: TempData,
    val uvi: Double,
    val weather: List<WeatherData>,
    val windDeg: Double,
    val windSpeed: Double
)