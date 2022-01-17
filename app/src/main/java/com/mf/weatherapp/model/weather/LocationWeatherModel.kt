package com.mf.weatherapp.model.weather

data class LocationWeatherModel(
    val daily: List<WeatherInfoModel>,
    val lat: Double,
    val lon: Double,
    val timezone: String = "",
    val timezoneOffset: Double
)