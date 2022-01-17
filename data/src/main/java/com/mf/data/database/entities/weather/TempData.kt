package com.mf.data.database.entities.weather

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TempData(
    val day: Double,
    val eve: Double,
    val max: Double,
    val min: Double,
    val morn: Double,
    val night: Double
)