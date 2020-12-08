package com.example.covidtracker.listerners

import com.example.covidtracker.model.StatesResponseModel

interface StatesRecyclerViewItemClick {
        fun onStateClicked(statesResponse : StatesResponseModel, position : Int)
}