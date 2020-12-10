package com.example.covidtracker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.covidtracker.R
import com.example.covidtracker.UIModel.StateDataUIModel
import com.example.covidtracker.listerners.StateDataFragmentListener
import com.example.covidtracker.model.ApiResponseModel
import com.example.covidtracker.model.StatesResponseModel
import com.example.covidtracker.viewmodel.StateDataViewModel
import kotlinx.android.synthetic.main.fragment_country_today.*
import kotlinx.android.synthetic.main.fragment_country_total.*

class TotalCountryFragment : Fragment() {

    private lateinit var statesDataViewModel: StateDataViewModel

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
//        var bundle = Bundle()
        val state : String = arguments?.getString("stateData").toString()
        observeLiveStatesDetailsData()
        statesDataViewModel.stateData("ca")

    }

    private fun observeLiveStatesDetailsData() {
        statesDataViewModel.liveDataOfState.observe(this, Observer {
            when (it) {

                is StateDataUIModel.Success -> {
                    it.apiResponseModel

                    tvSeriousTotal.text = it.apiResponseModel[0].totalTestResultsIncrease.toString()
                    tvRecoveredTotal.text = it.apiResponseModel[0].totalTestResults.toString()
                    tvDeathTotal.text = it.apiResponseModel[0].death.toString()
                    tvActiveTotal.text = it.apiResponseModel[0].totalTestsViral.toString()
                    tvAffectedTotal.text = it.apiResponseModel[0].total.toString()
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