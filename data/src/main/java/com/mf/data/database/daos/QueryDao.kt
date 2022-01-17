package com.mf.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mf.data.database.entities.QueryData
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow

@Dao
interface QueryDao {
    @Query("SELECT * FROM QueryData")
    fun observeQueries() : Flowable<List<QueryData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: QueryData)
}