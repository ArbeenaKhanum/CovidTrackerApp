package com.example.covidtracker.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.covidtracker.listerners.StatesRecyclerViewItemClick
import com.example.covidtracker.model.StatesResponseModel
import kotlinx.android.synthetic.main.list_of_states.view.*

class StatesViewHolder (private val view : View, private val statesListener :
        StatesRecyclerViewItemClick) : RecyclerView.ViewHolder(view) {
    fun setData(statesModel: StatesResponseModel) {
        view.apply {
            tvStateName.text = statesModel.state

            stateDataBtn.setOnClickListener {
                statesListener.onStateClicked(statesModel, position)
            }
        }
    }
}