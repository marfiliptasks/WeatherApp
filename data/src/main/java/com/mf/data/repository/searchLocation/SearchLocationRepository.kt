package com.mf.data.repository.searchLocation

import com.mf.domain.consts.WILDCARD
import com.mf.domain.dataSource.location.ILocationLocalDataSource
import com.mf.domain.repository.ILocationRepository
import com.mf.domain.dataSource.location.ILocationRemoteDataSource
import com.mf.domain.models.location.LocationEntity
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class SearchLocationRepository @Inject constructor(
    private val remoteDataSource: ILocationRemoteDataSource,
    private val localDataSource: ILocationLocalDataSource
) : ILocationRepository {

    override fun searchLocation(query: String): Single<List<LocationEntity>> =
        localDataSource.getLocations(query)
            .flatMap { checkBothDataSources(it, query) }

    private fun checkBothDataSources(result: List<LocationEntity>, query: String) =
        if (result.isEmpty() && query.isNotEmpty() && query != WILDCARD) {
            remoteDataSource.searchForLocation(query).doAfterSuccess {
                localDataSource.cacheResponse(it, query)
                localDataSource.cacheQuery(query)
            }
        } else {
            Single.just(result)
        }

    override fun observeQueries(): Flowable<List<String>> = localDataSource.observeQueries()

}