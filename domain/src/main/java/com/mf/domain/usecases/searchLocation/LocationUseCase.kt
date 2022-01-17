package com.mf.domain.usecases.searchLocation

import com.mf.domain.consts.WILDCARD
import com.mf.domain.models.location.LocationEntity
import com.mf.domain.repository.ILocationRepository
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LocationUseCase @Inject constructor(
    private val locationRepository: ILocationRepository
) : ILocationUseCase {

    override fun searchForLocation(query: String): Single<List<LocationEntity>> =
        locationRepository.searchLocation(query.replaceQueryWithWildCard())
            .subscribeOn(Schedulers.io())

    override fun observeQueries(): Flowable<List<String>> =
        locationRepository.observeQueries().subscribeOn(Schedulers.io())


    private fun String.replaceQueryWithWildCard(): String = if (isEmpty()) {
        WILDCARD
    } else this

}

