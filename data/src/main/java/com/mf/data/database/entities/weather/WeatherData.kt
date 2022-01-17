package com.mf.data.database.entities.weather

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherData(
    val description: String,
    val icon: String,
    val id: Double,
    val main: String
)