package com.mf.data.api.responseModels.location

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationResponseModel(
    val country: String,
    val lat: Double,
    val lon: Double,
    val name: String,
    val state: String = "-"
)
