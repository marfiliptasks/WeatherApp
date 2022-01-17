package com.mf.data.repository.weather

import com.mf.domain.dataSource.weather.IWeatherLocalDataSource
import com.mf.domain.dataSource.weather.IWeatherRemoteDataSource
import com.mf.domain.models.weather.LocationWeatherEntity
import com.mf.domain.repository.IWeatherRepository
import io.reactivex.Single
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val remoteDataSource: IWeatherRemoteDataSource,
    private val localDataSource: IWeatherLocalDataSource
) : IWeatherRepository {

    override fun getWeather(
        lat: Double, lon: Double, from: Long, to: Long
    ): Single<LocationWeatherEntity> =
        localDataSource
            .getWeather(lat, lon, from, to)
            .onErrorResumeNext {
                remoteDataSource.getWeather(lat, lon).doAfterSuccess(localDataSource::cacheWeatherResponse)
            }
}