package com.mf.data.di

import com.mf.data.repository.searchLocation.SearchLocationLocalDataSource
import com.mf.data.repository.searchLocation.SearchLocationRemoteDataSource
import com.mf.data.repository.weather.WeatherLocalDataSource
import com.mf.data.repository.weather.WeatherRemoteDataSource
import com.mf.domain.dataSource.location.ILocationLocalDataSource
import com.mf.domain.dataSource.location.ILocationRemoteDataSource
import com.mf.domain.dataSource.weather.IWeatherLocalDataSource
import com.mf.domain.dataSource.weather.IWeatherRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsRemoteLocationDataSource(dataSource: SearchLocationRemoteDataSource): ILocationRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsLocationDataSource(dataSource: SearchLocationLocalDataSource): ILocationLocalDataSource

    @Binds
    @Singleton
    abstract fun bindsRemoteWeatherLocationDataSource(dataSource: WeatherRemoteDataSource): IWeatherRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsLocalWeatherLocationDataSource(dataSource: WeatherLocalDataSource): IWeatherLocalDataSource
}