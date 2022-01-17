package com.mf.data.api.responseModels.weather

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class WeatherStateResponse(
    val clouds: Double = 0.0,
    @field:Json(name = "dew_point")
    val dewPoint: Double = 0.0,
    val dt: Date = Date(),
    @field:Json(name = "feels_like")
    val feelsLike: FeelsLikeResponse = FeelsLikeResponse(),
    val humidity: Double = 0.0,
    val pop: Double = 0.0,
    val pressure: Double = 0.0,
    val rain: Double = 0.0,
    val snow: Double = 0.0,
    val sunrise: Date = Date(),
    val sunset: Date = Date(),
    val temp: TempResponse = TempResponse(),
    val uvi: Double = 0.0,
    val weather: List<WeatherResponse> = listOf(),
    @field:Json(name = "wind_deg")
    val windDeg: Double = 0.0,
    @field:Json(name = "wind_speed")
    val windSpeed: Double = 0.0
)