package com.mf.domain.usecases.searchLocation

import com.mf.domain.models.location.LocationEntity
import io.reactivex.Flowable
import io.reactivex.Single

interface ILocationUseCase {
    fun searchForLocation(query: String): Single<List<LocationEntity>>
    fun observeQueries(): Flowable<List<String>>
}