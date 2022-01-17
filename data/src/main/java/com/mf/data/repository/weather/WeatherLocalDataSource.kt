package com.mf.data.repository.weather

import com.mf.data.database.daos.WeatherDao
import com.mf.data.mappers.toData
import com.mf.data.mappers.toEntity
import com.mf.domain.dataSource.weather.IWeatherLocalDataSource
import com.mf.domain.models.weather.LocationWeatherEntity
import io.reactivex.Single
import javax.inject.Inject

class
WeatherLocalDataSource @Inject constructor(
    private val weatherDao: WeatherDao
) : IWeatherLocalDataSource {

    override fun getWeather(
        lat: Double,
        lon: Double,
        from: Long,
        to: Long
    ): Single<LocationWeatherEntity> =
        weatherDao.getWeatherInfo(lat, lon, from, to).map { result ->
            result.toEntity()
        }
    override fun cacheWeatherResponse(weather: LocationWeatherEntity) =
        weatherDao.cacheWeatherInfo(weather.toData())
}