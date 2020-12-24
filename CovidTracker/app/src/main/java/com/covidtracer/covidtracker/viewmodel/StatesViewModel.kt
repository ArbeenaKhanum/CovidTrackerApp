package com.covidtracer.covidtracker.viewmodel

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.covidtracer.covidtracker.model.StatesResponseModel
import com.covidtracer.covidtracker.UIModel.StatesUIModel
import com.covidtracer.covidtracker.database.StatesApiDatabase
import com.covidtracer.covidtracker.database.StatesName
import com.covidtracer.covidtracker.repository.StatesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StatesViewModel(private val context: Context, private val owner: LifecycleOwner) :
    ViewModel(), Callback<List<StatesResponseModel>> {

    private val statesRepository = StatesRepository(this)
    private val mutableLiveData = MutableLiveData<StatesUIModel>()
    val liveData: LiveData<StatesUIModel> = mutableLiveData

    override fun onFailure(call: Call<List<StatesResponseModel>>, t: Throwable) {
//        mutableLiveData.value = StatesUIModel.Failure(t.message!!)
    }

    override fun onResponse(
        call: Call<List<StatesResponseModel>>,
        response: Response<List<StatesResponseModel>>
    ) {
        response.body()?.let {
//            mutableLiveData.value = StatesUIModel.Success(it)
            CoroutineScope(Dispatchers.IO).launch {
                for (i in it.indices) {
                    val statesName = StatesName(stateName = it[i].name.toString())
                    StatesApiDatabase.getInstance(context).statesNameDao.insertStateNames(statesName)
                }
            }
        }
    }

    fun statesApiCall() {
        StatesApiDatabase.getInstance(context).statesNameDao.getStateNames()
            .observe(owner, Observer {
                if (it.isNullOrEmpty()) {
                    statesRepository.getListOfStates()
                }
            })
    }

    fun fetchStatesNameFromDB(): LiveData<List<StatesResponseModel>> {
        return StatesApiDatabase.getInstance(context).statesNameDao.getStateNames()
    }

    val stateData = MutableLiveData<String>()

    fun sendSharedData(states: String) {
        stateData.value = states
    }
}