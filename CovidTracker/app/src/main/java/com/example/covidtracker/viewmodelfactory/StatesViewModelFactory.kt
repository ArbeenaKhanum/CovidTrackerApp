package com.example.covidtracker.viewmodelfactory

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.covidtracker.viewmodel.StatesViewModel

class StatesViewModelFactory(private val context: Context, private val owner: LifecycleOwner) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StatesViewModel::class.java)) {
            return StatesViewModel(context, owner) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}