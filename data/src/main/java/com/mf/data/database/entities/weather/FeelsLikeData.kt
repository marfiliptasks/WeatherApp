package com.mf.data.database.entities.weather

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FeelsLikeData(
    val day: Double,
    val eve: Double,
    val morn: Double,
    val night: Double
)