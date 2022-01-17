package com.mf.data.api.retrofit

import com.mf.data.api.responseModels.location.LocationResponseModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_VERSION = 1.0

interface ILocationService {
    @GET("geo/$API_VERSION/direct")
    fun searchLocations(
        @Query("q") searchQuery: String,
        @Query("limit") limit: Int
    ): Single<List<LocationResponseModel>>
}