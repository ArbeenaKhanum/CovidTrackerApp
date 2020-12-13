package com.example.covidtracker.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.covidtracker.model.ApiResponseModel

@Dao
interface StatesApiDao {
    @Insert
    suspend fun insertStatesData(statesDataDetails: StatesDataDetails)

    @Query("Select * From StatesDataDetails")
    fun getAllStateData(): LiveData<List<ApiResponseModel>>
}