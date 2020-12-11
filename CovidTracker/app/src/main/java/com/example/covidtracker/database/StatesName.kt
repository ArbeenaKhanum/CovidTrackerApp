package com.example.covidtracker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "StateNames")
data class StatesName(
    @PrimaryKey(autoGenerate = true)
    var stateNameId: Int = 0,
    @ColumnInfo(name = "stateName")
    val stateName: String
)