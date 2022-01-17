package com.mf.domain.repository

import com.mf.domain.models.location.LocationEntity
import io.reactivex.Flowable
import io.reactivex.Single

interface ILocationRepository {
    fun searchLocation(query: String): Single<List<LocationEntity>>
    fun observeQueries(): Flowable<List<String>>
}