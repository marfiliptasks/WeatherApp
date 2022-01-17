package com.mf.data.database.entities.location

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocationData (
    @PrimaryKey
    val latLonKey: String,
    val name: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val userQuery: String,
    val state: String
)