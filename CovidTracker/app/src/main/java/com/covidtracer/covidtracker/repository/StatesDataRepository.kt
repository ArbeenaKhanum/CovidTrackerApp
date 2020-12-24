package com.covidtracer.covidtracker.repository

import com.covidtracer.covidtracker.model.ApiResponseModel
import com.covidtracer.covidtracker.network.Network
import com.covidtracer.covidtracker.network.ResponseModelApiClient
import retrofit2.Callback

class StatesDataRepository (private val callback : Callback<List<ApiResponseModel>>) {
    fun getStateData(state : String) {
        val apiClient = Network.getInstance().create(ResponseModelApiClient::class.java)
        val call = apiClient.getStatesApi(state)
        call.enqueue(callback)
    }
}