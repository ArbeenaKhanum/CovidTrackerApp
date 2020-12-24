package com.covidtracer.covidtracker.network

import com.covidtracer.covidtracker.model.ApiResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ResponseModelApiClient {
    @GET("/v1/states/{state}/daily.json")
    fun getStatesApi(@Path("state") state: String) : Call<List<ApiResponseModel>>
}