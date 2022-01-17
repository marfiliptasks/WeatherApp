package com.mf.data.api.responseModels.weather

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationWeatherResponse(
    val daily: List<WeatherStateResponse> = listOf(),
    val lat: Double = 0.0,
    val lon: Double = 0.0,
    val timezone: String = "",
    @field:Json(name = "timezone_offset")
    val timezoneOffset: Double = 0.0
)