package com.mf.domain.dataSource.location

import com.mf.domain.models.location.LocationEntity
import io.reactivex.Flowable
import io.reactivex.Single

interface ILocationLocalDataSource {
    fun cacheQuery(query: String)
    fun observeQueries() : Flowable<List<String>>
    fun getLocations(locationName: String) : Single<List<LocationEntity>>
    fun cacheResponse(locations: List<LocationEntity>, query: String)
}