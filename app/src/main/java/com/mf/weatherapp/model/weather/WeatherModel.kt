package com.mf.weatherapp.model.weather

data class WeatherModel(
    val description: String,
    val icon: String,
    val id: Double,
    val main: String
)