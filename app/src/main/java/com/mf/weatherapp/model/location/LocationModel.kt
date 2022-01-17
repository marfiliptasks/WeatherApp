package com.mf.weatherapp.model.location

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationModel(
    val country: String,
    val lat: Double,
    val lon: Double,
    val name: String,
    val state: String
) : Parcelable {
    fun getNameWithCountryCode() = "$name, $country"
    fun getKey() = "${lat}_${lon}"
}