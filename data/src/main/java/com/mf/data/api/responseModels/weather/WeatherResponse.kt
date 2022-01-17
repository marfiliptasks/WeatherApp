package com.mf.data.api.responseModels.weather

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponse(
    val description: String = "",
    val icon: String = "",
    val id: Double = 0.0,
    val main: String = ""
)