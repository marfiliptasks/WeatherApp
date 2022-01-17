package com.mf.data.mappers

import com.mf.data.database.entities.weather.*
import com.mf.data.api.responseModels.weather.*
import com.mf.domain.models.weather.*

fun LocationWeatherResponse.toEntity() =
    LocationWeatherEntity(
        daily.map { it.toEntity() },
        lat,
        lon,
        timezone,
        timezoneOffset
    )

fun WeatherStateResponse.toEntity() =
    WeatherInfoEntity(
        clouds,
        dewPoint,
        dt,
        feelsLike.toEntity(),
        humidity,
        pop,
        pressure,
        rain,
        snow,
        sunrise,
        sunset,
        temp.toEntity(),
        uvi,
        weather.map { it.toEntity() },
        windDeg,
        windSpeed
    )

fun WeatherResponse.toEntity() = WeatherEntity(
    description, icon, id, main
)

fun FeelsLikeResponse.toEntity() = FeelsLikeEntity(
    day, eve, morn, night
)

fun TempResponse.toEntity() = TempEntity(
    day, eve, max, min, morn, night
)

fun LocationWeatherEntity.toData() =
    LocationWeatherData(
        "${lat}_$lon",
        daily.map { it.toData() },
        lat,
        lon,
        timezone,
        timezoneOffset,
        savedDate
    )

fun WeatherInfoEntity.toData() =
    WeatherStateData(
        clouds,
        dewPoint,
        dt,
        feelsLike.toData(),
        humidity,
        pop,
        pressure,
        rain,
        snow,
        sunrise,
        sunset,
        temp.toData(),
        uvi,
        weather.map { it.toData() },
        windDeg,
        windSpeed
    )

fun WeatherEntity.toData() = WeatherData(
    description, icon, id, main
)

fun FeelsLikeEntity.toData() = FeelsLikeData(
    day, eve, morn, night
)

fun TempEntity.toData() = TempData(
    day, eve, max, min, morn, night
)

fun LocationWeatherData.toEntity() =
    LocationWeatherEntity(
        daily.map { it.toEntity() },
        lat,
        lon,
        timezone,
        timezoneOffset,
        savedDate
    )

fun WeatherStateData.toEntity() =
    WeatherInfoEntity(
        clouds,
        dewPoint,
        dt,
        feelsLike.toEntity(),
        humidity,
        pop,
        pressure,
        rain,
        snow,
        sunrise,
        sunset,
        temp.toEntity(),
        uvi,
        weather.map { it.toEntity() },
        windDeg,
        windSpeed
    )

fun WeatherData.toEntity() = WeatherEntity(
    description, icon, id, main
)

fun FeelsLikeData.toEntity() = FeelsLikeEntity(
    day, eve, morn, night
)

fun TempData.toEntity() = TempEntity(
    day, eve, max, min, morn, night
)
