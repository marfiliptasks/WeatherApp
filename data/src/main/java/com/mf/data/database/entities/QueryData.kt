package com.mf.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QueryData(
    @PrimaryKey val query: String,
)