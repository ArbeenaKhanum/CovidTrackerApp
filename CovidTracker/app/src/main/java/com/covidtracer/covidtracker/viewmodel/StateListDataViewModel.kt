package com.covidtracer.covidtracker.viewmodel

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.covidtracer.covidtracker.UIModel.StateDataUIModel
import com.covidtracer.covidtracker.database.StatesApiDatabase
import com.covidtracer.covidtracker.database.StatesDataDetails
import com.covidtracer.covidtracker.model.ApiResponseModel
import com.covidtracer.covidtracker.repository.StatesDataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StateListDataViewModel(private val context: Context, private val owner: LifecycleOwner) : ViewModel(),
    Callback<List<ApiResponseModel>> {
    private val statesDataRepository = StatesDataRepository(this)
    private val mutableLiveData = MutableLiveData<StateDataUIModel>()
    val liveDataOfState: LiveData<StateDataUIModel> = mutableLiveData


    override fun onFailure(call: Call<List<ApiResponseModel>>, t: Throwable) {
//        mutableLiveData.value = StateDataUIModel.Failure(t.message!!)
    }

    override fun onResponse(
        call: Call<List<ApiResponseModel>>,
        response: Response<List<ApiResponseModel>>
    ) {
        response.body()?.let {
//            mutableLiveData.value = StateDataUIModel.Success(it)

            CoroutineScope(Dispatchers.IO).launch {
                for (i in it.indices) {
                    val statesDataDetails = StatesDataDetails(
                        affected = it[i].positive.toString(),
                        death = it[i].positiveCasesViral.toString(),
                        recovered = it[i].deathIncrease.toString(),
                        active = it[i].hospitalizedCurrently.toString(),
                        serious = it[i].deathIncrease.toString()
                    )
                    StatesApiDatabase.getInstance(context).statesApiDao.getAllStateData();
                }
            }
        }
    }

    fun stateDataDetails(state: String) {
        StatesApiDatabase.getInstance(context).statesApiDao.getAllStateData().observe(owner, Observer {
            if (it.isNullOrEmpty()){
                statesDataRepository.getStateData(state)
            }
        })
    }

    fun fetchStateListsDetailsFromDB(): LiveData<List<ApiResponseModel>> {
        return StatesApiDatabase.getInstance(context).statesApiDao.getAllStateData()
    }
}