package com.mf.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mf.data.database.entities.location.LocationData
import io.reactivex.Single

@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun cacheLocation(location: LocationData)

    @Query("SELECT * FROM locationdata WHERE name LIKE '%' || :locationName || '%' OR userQuery LIKE '%' || :locationName || '%'")
    fun getLocation(locationName: String) : Single<List<LocationData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun cacheLocations(locations: List<LocationData>)
}