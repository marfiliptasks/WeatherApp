package com.mf.data.repository.searchLocation

import com.mf.data.database.daos.LocationDao
import com.mf.data.database.daos.QueryDao
import com.mf.data.database.entities.QueryData
import com.mf.data.mappers.toData
import com.mf.data.mappers.toEntity
import com.mf.domain.dataSource.location.ILocationLocalDataSource
import com.mf.domain.models.location.LocationEntity
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class SearchLocationLocalDataSource @Inject constructor(
    private val queryDao: QueryDao,
    private val locationsDao: LocationDao
) : ILocationLocalDataSource {

    override fun cacheQuery(query: String) = queryDao.insert(QueryData(query))

    override fun observeQueries(): Flowable<List<String>> =
        queryDao.observeQueries().map { queryLists ->
            queryLists.map { it.query }
        }

    override fun getLocations(locationName: String): Single<List<LocationEntity>> =
        locationsDao.getLocation(locationName).map { locationDatas ->
            locationDatas.map { it.toEntity() }
        }

    override fun cacheResponse(locations: List<LocationEntity>, query: String) =
        locationsDao.cacheLocations(locations.map { it.toData(query) })
}