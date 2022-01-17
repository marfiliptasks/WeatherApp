package com.mf.weatherapp.model.weather

import java.text.SimpleDateFormat
import java.util.*

data class WeatherInfoModel(
    val clouds: Double,
    val dewPoint: Double,
    val dt: Date,
    val feelsLike: FeelsLikeModel,
    val humidity: Double,
    val pop: Double,
    val pressure: Double,
    val rain: Double,
    val snow: Double,
    val sunrise: Date,
    val sunset: Date,
    val temp: TempModel,
    val uvi: Double,
    val weather: List<WeatherModel>,
    val windDeg: Double,
    val windSpeed: Double,
) {
    private val formatter: SimpleDateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    val formattedSunrise: String = formatter.format(sunrise)
    val formattedSunset: String = formatter.format(sunset)
    val formattedHeaderTime: String = SimpleDateFormat("DD MMM", Locale.getDefault()).format(dt)
}