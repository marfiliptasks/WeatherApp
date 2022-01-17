package com.mf.data.repository.searchLocation

import com.mf.data.api.retrofit.ILocationService
import com.mf.data.api.responseModels.location.LocationResponseModel
import com.mf.data.mappers.toEntity
import com.mf.domain.dataSource.location.ILocationRemoteDataSource
import com.mf.domain.models.location.LocationEntity
import io.reactivex.Single
import javax.inject.Inject

class SearchLocationRemoteDataSource @Inject constructor(
    private val api: ILocationService,
) : ILocationRemoteDataSource {

    override fun searchForLocation(query: String): Single<List<LocationEntity>> =
        api.searchLocations(query, RECORDS_LIMIT)
            .map(List<LocationResponseModel>::toEntity)

    companion object {
        private const val RECORDS_LIMIT = 5
    }
}