package com.example.covidtracker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covidtracker.model.ApiResponseModel
import com.example.covidtracker.UIModel.StateDataUIModel
import com.example.covidtracker.repository.StatesDataRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StateDataViewModel : ViewModel(), Callback<List<ApiResponseModel>> {
    private val statesDataRepository = StatesDataRepository(this)
    private val mutableLiveData = MutableLiveData<StateDataUIModel>()
    val liveDataOfState: LiveData<StateDataUIModel> = mutableLiveData

    override fun onFailure(call: Call<List<ApiResponseModel>>, t: Throwable) {
        mutableLiveData.value = StateDataUIModel.Failure(t.message!!)
    }

    override fun onResponse(
        call: Call<List<ApiResponseModel>>,
        response: Response<List<ApiResponseModel>>
    ) {

        response.body()?.let {
            mutableLiveData.value = StateDataUIModel.Success(it)

        }
    }

    fun stateData() {
        statesDataRepository.getStateData()
    }
}