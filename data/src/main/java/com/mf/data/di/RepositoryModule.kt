package com.mf.data.di

import com.mf.data.repository.searchLocation.SearchLocationRepository
import com.mf.data.repository.weather.WeatherRepository
import com.mf.domain.repository.ILocationRepository
import com.mf.domain.repository.IWeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsLocationRepository(locationRepository: SearchLocationRepository): ILocationRepository

    @Binds
    @Singleton
    abstract fun bindsWeatherRepository(weatherRepository: WeatherRepository): IWeatherRepository
}