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
import kotlinx.android.synthetic.main.fragment_country_today.*

class TodayCountryFragment : Fragment() {
    private lateinit var statesDataViewModel: StateDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_today, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statesDataViewModel = ViewModelProvider(this).get(StateDataViewModel::class.java)

        val state: String = arguments?.getString("stateData").toString()
        observeLiveStatesTodayData()
        statesDataViewModel.stateData()
    }

    private fun observeLiveStatesTodayData() {
        statesDataViewModel.liveDataOfState.observe(this, Observer {
            when (it) {

                is StateDataUIModel.Success -> {
                    it.apiResponseModel

                    tvAffectedToday.text = it.apiResponseModel[1].positive.toString()
                    tvRecoveredToday.text = it.apiResponseModel[1].posNeg.toString()
                    tvDeathToday.text = it.apiResponseModel[1].death.toString()
                    tvActiveToday.text = it.apiResponseModel[1].hospitalizedCurrently.toString()
                    tvAffectedToday.text = it.apiResponseModel[1].positiveCasesViral.toString()
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