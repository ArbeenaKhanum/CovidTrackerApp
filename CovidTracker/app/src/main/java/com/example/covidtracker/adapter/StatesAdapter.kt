package com.example.covidtracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covidtracker.R
import com.example.covidtracker.model.StatesResponseModel
import com.example.covidtracker.listerners.StatesRecyclerViewItemClick
import com.example.covidtracker.viewholder.StatesViewHolder

class StatesAdapter(
    private var statesResponseList: List<StatesResponseModel>,
    private val statesListener: StatesRecyclerViewItemClick
) : RecyclerView.Adapter<StatesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_of_states, parent, false)
        return StatesViewHolder(view, statesListener)
    }

    override fun getItemCount(): Int {
        return this.statesResponseList.size
    }

    override fun onBindViewHolder(holder: StatesViewHolder, position: Int) {
        val statesModel = statesResponseList[position]
        holder.setData(statesModel)
    }

    fun updateStatesList(statesResponseList: List<StatesResponseModel>) {
        this.statesResponseList = statesResponseList
        notifyDataSetChanged()
    }
}