package com.mf.domain.models.weather

import java.util.*

data class LocationWeatherEntity(
    val daily: List<WeatherInfoEntity>,
    val lat: Double,
    val lon: Double,
    val timezone: String = "",
    val timezoneOffset: Double = 0.0,
    val savedDate: Long = Date().time
)