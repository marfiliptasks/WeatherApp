package com.mf.data.database.converters

import androidx.room.TypeConverter
import com.mf.data.api.retrofit.DateAdapter
import com.mf.data.database.entities.weather.WeatherStateData
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.util.*

class LocationWeatherConverters {
    private val moshiAdapter: JsonAdapter<MutableList<WeatherStateData>> by lazy {
        Moshi.Builder().add(Date::class.java, DateAdapter()).build().adapter(
            Types.newParameterizedType(
                MutableList::class.java,
                WeatherStateData::class.java
            )
        )
    }

    @TypeConverter
    fun toJson(locationWeatherData: List<WeatherStateData>): String =
        moshiAdapter.toJson(locationWeatherData.toMutableList())

    @TypeConverter
    fun fromJson(locationWeatherData: String): List<WeatherStateData>? =
        moshiAdapter.fromJson(locationWeatherData)
}