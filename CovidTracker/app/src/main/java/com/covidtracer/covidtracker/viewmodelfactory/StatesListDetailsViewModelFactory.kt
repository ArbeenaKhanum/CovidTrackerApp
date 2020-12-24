package com.covidtracer.covidtracker.viewmodelfactory

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.covidtracer.covidtracker.viewmodel.StateListDataViewModel

class StatesListDetailsViewModelFactory(private val context: Context, private val owner: LifecycleOwner) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StateListDataViewModel::class.java)) {
            return StateListDataViewModel(context, owner) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}