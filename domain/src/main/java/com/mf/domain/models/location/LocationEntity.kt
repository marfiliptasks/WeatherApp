package com.mf.domain.models.location

data class LocationEntity(
    val country: String,
    val lat: Double,
    val lon: Double,
    val name: String,
    val state: String
)