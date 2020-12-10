package com.example.covidtracker.repository

import com.example.covidtracker.model.ApiResponseModel
import com.example.covidtracker.network.Network
import com.example.covidtracker.network.ResponseModelApiClient
import retrofit2.Callback

class StatesDataRepository (private val callback : Callback<List<ApiResponseModel>>) {
    fun getStateData() {
        val apiClient = Network.getInstance().create(ResponseModelApiClient::class.java)
        val call = apiClient.getStatesApi()
        call.enqueue(callback)
    }
}