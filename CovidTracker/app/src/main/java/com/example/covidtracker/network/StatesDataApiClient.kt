package com.example.covidtracker.network

import com.example.covidtracker.model.StatesDataResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StatesDataApiClient {
    @GET("/v1/states/{state}/current.json")
    fun getStatesData(@Path("state") state: String): Call<StatesDataResponseModel>
}