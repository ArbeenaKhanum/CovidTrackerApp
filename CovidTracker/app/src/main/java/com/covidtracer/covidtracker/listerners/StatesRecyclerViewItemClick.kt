package com.covidtracer.covidtracker.listerners

import com.covidtracer.covidtracker.model.StatesResponseModel

interface StatesRecyclerViewItemClick {
        fun onStateClicked(statesResponse : StatesResponseModel, position : Int)
}