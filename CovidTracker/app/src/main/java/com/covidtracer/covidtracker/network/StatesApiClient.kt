package com.covidtracer.covidtracker.network

import com.covidtracer.covidtracker.model.StatesResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface StatesApiClient {

    @GET("/v1/states/info.json")
    fun getStatesNames() : Call<List<StatesResponseModel>>
}