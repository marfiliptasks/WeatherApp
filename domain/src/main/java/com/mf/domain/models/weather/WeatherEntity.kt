package com.mf.domain.models.weather

data class WeatherEntity(
    val description: String,
    val icon: String,
    val id: Double,
    val main: String
)