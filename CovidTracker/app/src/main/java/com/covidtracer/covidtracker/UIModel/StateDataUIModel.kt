package com.covidtracer.covidtracker.UIModel

import com.covidtracer.covidtracker.model.ApiResponseModel

sealed class StateDataUIModel {
    data class Success(val apiResponseModel: List<ApiResponseModel>) : StateDataUIModel()
    data class Failure(val error: String) : StateDataUIModel()
}