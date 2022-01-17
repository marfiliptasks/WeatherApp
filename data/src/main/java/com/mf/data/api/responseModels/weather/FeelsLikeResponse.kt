package com.mf.data.api.responseModels.weather

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FeelsLikeResponse(
    val day: Double = 0.0,
    val eve: Double = 0.0,
    val morn: Double = 0.0,
    val night: Double = 0.0
)