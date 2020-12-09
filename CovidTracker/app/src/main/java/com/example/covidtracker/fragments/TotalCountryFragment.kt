package com.example.covidtracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.covidtracker.R
import com.example.covidtracker.UIModel.StateDataUIModel
import com.example.covidtracker.viewmodel.StateDataViewModel

class TotalCountryFragment : Fragment() {
    lateinit var statesDataViewModel: StateDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_total, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statesDataViewModel = ViewModelProvider(this).get(StateDataViewModel::class.java)
        observeLiveStatesDetailsData()
    }

    private fun observeLiveStatesDetailsData() {
        statesDataViewModel.liveDataOfState.observe(this, Observer {
            when (it) {

                is StateDataUIModel.Success -> {
                    it.stateDataResponseModel

                }

                is StateDataUIModel.Failure -> {
                    Toast.makeText(
                        context, "Error message ${it.error}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }
}