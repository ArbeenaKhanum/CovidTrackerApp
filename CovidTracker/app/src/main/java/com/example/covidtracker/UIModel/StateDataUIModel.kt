package com.example.covidtracker.UIModel

import com.example.covidtracker.model.ApiResponseModel

sealed class StateDataUIModel {
    data class Success(val apiResponseModel: List<ApiResponseModel>) : StateDataUIModel()
    data class Failure(val error: String) : StateDataUIModel()
}