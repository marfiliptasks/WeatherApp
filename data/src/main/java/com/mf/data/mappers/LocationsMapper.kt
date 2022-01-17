package com.mf.data.mappers

import com.mf.data.database.entities.location.LocationData
import com.mf.data.api.responseModels.location.LocationResponseModel
import com.mf.domain.models.location.LocationEntity


fun LocationResponseModel.toEntity() = LocationEntity(
    country, lat, lon, name, state
)

fun List<LocationResponseModel>.toEntity() = map {
    it.toEntity()
}

fun LocationData.toEntity() = LocationEntity(
    country, lat, lon, name, state
)

fun LocationEntity.toData(userQuery: String) = LocationData(
    "${lat}_${lon}", name, country, lat, lon, userQuery, state
)
