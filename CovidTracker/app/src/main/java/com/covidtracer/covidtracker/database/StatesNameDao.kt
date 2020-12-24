package com.covidtracer.covidtracker.database


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.covidtracer.covidtracker.model.StatesResponseModel

@Dao
interface StatesNameDao {
    @Insert
    suspend fun insertStateNames(statesName: StatesName)

    @Query("Select * FROM StateNames")
    fun getStateNames(): LiveData<List<StatesResponseModel>>
}