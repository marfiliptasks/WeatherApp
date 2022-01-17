package com.mf.weatherapp.mappers

import com.mf.domain.models.location.LocationEntity
import com.mf.weatherapp.model.location.LocationModel

fun List<LocationEntity>.toModel() = map {
    LocationModel(
        it.country,
        it.lat,
        it.lon,
        it.name,
        it.state
    )
}