package com.mf.weatherapp.ui.weather

import com.mf.domain.dateUtils.getEndOfDay
import com.mf.domain.dateUtils.getStartOfDay
import com.mf.domain.models.weather.LocationWeatherEntity
import com.mf.domain.usecases.weather.IWeatherUseCase
import com.mf.weatherapp.mappers.toDailyModel
import com.mf.weatherapp.model.location.LocationModel
import com.mf.weatherapp.model.weather.WeatherInfoModel
import com.mf.weatherapp.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherUseCase: IWeatherUseCase) :
    BaseViewModel<List<WeatherInfoModel>, LocationWeatherEntity>() {

    fun getWeatherInfo(location: LocationModel) = weatherUseCase.getWeather(
        location.lat,
        location.lon,
        getStartOfDay().timeInMillis,
        getEndOfDay().timeInMillis
    ).runWithBaseSideEffects(LocationWeatherEntity::toDailyModel)

}