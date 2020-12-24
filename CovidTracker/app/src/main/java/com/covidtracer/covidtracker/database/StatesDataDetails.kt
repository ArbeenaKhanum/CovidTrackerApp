package com.covidtracer.covidtracker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "StatesDataDetails")
data class StatesDataDetails(
    @PrimaryKey(autoGenerate = true)
    var stateId: Int = 0,
    @ColumnInfo(name = "affected")
    val affected: String,
    @ColumnInfo(name = "death")
    val death: String,
    @ColumnInfo(name = "recovered")
    val recovered: String,
    @ColumnInfo(name = "active")
    val active: String,
    @ColumnInfo(name = "serious")
    val serious: String
)