package com.covidtracer.covidtracker.repository

import com.covidtracer.covidtracker.model.StatesResponseModel
import com.covidtracer.covidtracker.network.Network
import com.covidtracer.covidtracker.network.StatesApiClient
import retrofit2.Callback

class StatesRepository(private val callback: Callback<List<StatesResponseModel>>) {
    fun getListOfStates() {
        val statesApiClient = Network.getInstance().create(StatesApiClient::class.java)
        val call = statesApiClient.getStatesNames()
        call.enqueue(callback)
    }
}