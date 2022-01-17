package com.mf.data.api.retrofit

import com.mf.data.api.responseModels.weather.LocationWeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_VERSION = 2.5
private const val FIELDS_TO_EXCLUDE = "hourly,minutely,alerts,current"
private const val UNITS = "metric"

interface IWeatherService {
    @GET("data/$API_VERSION/onecall")
    fun getWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("exclude") exclude: String = FIELDS_TO_EXCLUDE,
        @Query("units") units: String = UNITS
    ): Single<LocationWeatherResponse>
}