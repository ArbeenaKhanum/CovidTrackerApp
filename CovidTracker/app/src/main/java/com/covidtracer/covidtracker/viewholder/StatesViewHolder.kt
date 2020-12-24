package com.covidtracer.covidtracker.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.covidtracer.covidtracker.model.StatesResponseModel
import com.covidtracer.covidtracker.listerners.StatesRecyclerViewItemClick
import kotlinx.android.synthetic.main.list_of_states.view.*

class StatesViewHolder (private val view : View, private val statesListener :
        StatesRecyclerViewItemClick) : RecyclerView.ViewHolder(view) {
    fun setData(statesModel: StatesResponseModel) {
        view.apply {
            tvStateName.text = statesModel.name

            stateDataBtn.setOnClickListener {
                statesListener.onStateClicked(statesModel, position)
            }
        }
    }
}