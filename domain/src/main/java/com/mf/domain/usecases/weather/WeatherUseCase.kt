package com.mf.domain.usecases.weather

import com.mf.domain.models.weather.LocationWeatherEntity
import com.mf.domain.repository.IWeatherRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.math.RoundingMode
import javax.inject.Inject

class WeatherUseCase @Inject constructor(private val weatherRepository: IWeatherRepository) :
    IWeatherUseCase {

    override fun getWeather(
        lat: Double, lon: Double, from: Long, to: Long
    ): Single<LocationWeatherEntity> =
        weatherRepository.getWeather(lat.roundToExpectedDecimalPlaces(), lon.roundToExpectedDecimalPlaces(), from, to)
            .subscribeOn(Schedulers.io())

    private fun Double.roundToExpectedDecimalPlaces(): Double =
        toBigDecimal().setScale(WEATHER_RESPONSE_DECIMAL_PLACES, RoundingMode.HALF_UP).toDouble()

    private companion object {
        const val WEATHER_RESPONSE_DECIMAL_PLACES = 4
    }
}

