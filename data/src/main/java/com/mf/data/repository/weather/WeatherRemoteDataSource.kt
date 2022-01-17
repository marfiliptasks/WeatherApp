package com.mf.data.repository.weather

import com.mf.data.api.retrofit.IWeatherService
import com.mf.data.api.responseModels.weather.LocationWeatherResponse
import com.mf.data.mappers.toEntity
import com.mf.domain.dataSource.weather.IWeatherRemoteDataSource
import javax.inject.Inject

class WeatherRemoteDataSource @Inject constructor(
    private val service: IWeatherService
) : IWeatherRemoteDataSource {

    override fun getWeather(locationKey: Double, lon: Double) =
        service.getWeatherData(locationKey, lon)
            .map(LocationWeatherResponse::toEntity)
}

