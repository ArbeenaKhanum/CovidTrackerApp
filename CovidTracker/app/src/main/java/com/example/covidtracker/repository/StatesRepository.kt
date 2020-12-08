package com.example.covidtracker.repository

import com.example.covidtracker.model.StatesResponseModel
import com.example.covidtracker.network.Network
import com.example.covidtracker.network.StatesApiClient
import retrofit2.Callback

class StatesRepository(private val callback: Callback<List<StatesResponseModel>>) {
    fun getListOfStates() {
        val statesApiClient = Network.getInstance().create(StatesApiClient::class.java)
        val call = statesApiClient.getStatesNames()
        call.enqueue(callback)
    }
}