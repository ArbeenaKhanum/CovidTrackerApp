package com.example.covidtracker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "StatesDataDetails")
data class StatesDataDetails(
    @PrimaryKey(autoGenerate = true)
    var stateId: Int = 0,
    @ColumnInfo(name = "affected")
    val affected: Int,
    @ColumnInfo(name = "death")
    val death: Int, @ColumnInfo(name = "recovered")
    val recovered: Int,
    @ColumnInfo(name = "active")
    val active: String,
    @ColumnInfo(name = "serious")
    val serious: String
)
