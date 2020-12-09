package com.example.covidtracker.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covidtracker.model.StatesResponseModel
import com.example.covidtracker.UIModel.StatesUIModel
import com.example.covidtracker.repository.StatesRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StatesViewModel : ViewModel(), Callback<List<StatesResponseModel>> {

    private val statesRepository = StatesRepository(this)
    private val mutableLiveData = MutableLiveData<StatesUIModel>()
    val liveData: LiveData<StatesUIModel> = mutableLiveData

    override fun onFailure(call: Call<List<StatesResponseModel>>, t: Throwable) {
        mutableLiveData.value = StatesUIModel.Failure(t.message!!)
    }

    override fun onResponse(
        call: Call<List<StatesResponseModel>>,
        response: Response<List<StatesResponseModel>>
    ) {
        response.body()?.let {
            mutableLiveData.value = StatesUIModel.Success(it)
        }
    }

    fun statesApiCall() {
        statesRepository.getListOfStates()
    }
}