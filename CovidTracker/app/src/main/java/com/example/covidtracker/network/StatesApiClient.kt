package com.example.covidtracker.network

import com.example.covidtracker.model.StatesResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface StatesApiClient {

    @GET("/v1/states/current.json")
    fun getStatesNames() : Call<List<StatesResponseModel>>
}