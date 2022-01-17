package com.mf.weatherapp.mappers

import com.mf.domain.models.weather.*
import com.mf.weatherapp.model.weather.*

fun LocationWeatherEntity.toModel() =
    LocationWeatherModel(
        daily.map { it.toModel() },
        lat,
        lon,
        timezone,
        timezoneOffset
    )

fun WeatherInfoEntity.toModel() =
    WeatherInfoModel(
        clouds,
        dewPoint,
        dt,
        feelsLike.toModel(),
        humidity,
        pop,
        pressure,
        rain,
        snow,
        sunrise,
        sunset,
        temp.toModel(),
        uvi,
        weather.map { it.toModel() },
        windDeg,
        windSpeed
    )

fun WeatherEntity.toModel() = WeatherModel(
    description, icon, id, main
)

fun FeelsLikeEntity.toModel() = FeelsLikeModel(
    day, eve, morn, night
)

fun TempEntity.toModel() = TempModel(
    day, eve, max, min, morn, night
)

fun LocationWeatherEntity.toDailyModel() : List<WeatherInfoModel> = daily.map {
    it.toModel()
}