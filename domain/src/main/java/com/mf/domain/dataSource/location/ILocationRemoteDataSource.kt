package com.mf.domain.dataSource.location

import com.mf.domain.models.location.LocationEntity
import io.reactivex.Single

interface ILocationRemoteDataSource {
    fun searchForLocation(query: String): Single<List<LocationEntity>>
}