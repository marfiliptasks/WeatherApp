package com.mf.data.di

import com.mf.domain.usecases.searchLocation.ILocationUseCase
import com.mf.domain.usecases.searchLocation.LocationUseCase
import com.mf.domain.usecases.weather.IWeatherUseCase
import com.mf.domain.usecases.weather.WeatherUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    @Singleton
    abstract fun bindsSearchLocationUseCase(useCase: LocationUseCase): ILocationUseCase

    @Binds
    @Singleton
    abstract fun bindsWeatherUseCase(useCase: WeatherUseCase): IWeatherUseCase
}