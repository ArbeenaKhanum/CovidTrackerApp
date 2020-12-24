package com.covidtracer.covidtracker.UIModel

import com.covidtracer.covidtracker.model.StatesResponseModel

sealed class StatesUIModel {

    data class Success(val statesResponseList: List<StatesResponseModel>) : StatesUIModel()
    data class Failure(val error: String) : StatesUIModel()
}