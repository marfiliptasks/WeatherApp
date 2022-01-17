package com.mf.data.database.entities.weather

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import java.util.*

@Entity
@JsonClass(generateAdapter = true)
data class LocationWeatherData(
    @PrimaryKey
    val latLonKey: String,
    val daily: List<WeatherStateData>,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezoneOffset: Double,
    val savedDate: Long = Date().time
)