package com.example.covidtracker.UIModel

import com.example.covidtracker.model.StatesResponseModel

sealed class StatesUIModel {

    data class Success(val statesResponseList: List<StatesResponseModel>) : StatesUIModel()
    data class Failure(val error: String) : StatesUIModel()
}