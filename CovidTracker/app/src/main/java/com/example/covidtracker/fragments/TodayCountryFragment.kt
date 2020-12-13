package com.example.covidtracker.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.covidtracker.R
import com.example.covidtracker.UIModel.StateDataUIModel
import com.example.covidtracker.viewmodel.StateListDataViewModel
import com.example.covidtracker.viewmodel.StatesViewModel
import com.example.covidtracker.viewmodelfactory.StatesViewModelFactory
import kotlinx.android.synthetic.main.fragment_country_today.*

class TodayCountryFragment : Fragment() {
    lateinit var statesListDataViewModel: StateListDataViewModel
    lateinit var statesViewModel: StatesViewModel

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
        statesViewModel =
            StatesViewModelFactory(
                this.requireContext(),
                requireActivity()
            ).create(StatesViewModel::class.java)
        statesListDataViewModel =
            ViewModelProvider(requireActivity()).get(StateListDataViewModel::class.java)
        getStateFromViewModel()
        observeLiveStatesTodayData()
    }

    private fun getStateFromViewModel() {
        statesViewModel.stateData.observe(this, Observer {
            statesListDataViewModel.stateDataDetails(it)
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun observeLiveStatesTodayData() {
        statesListDataViewModel.liveDataOfState.observe(this, Observer {
            when (it) {

                is StateDataUIModel.Success -> {
                    for (i in it.apiResponseModel.indices) {
                        Toast.makeText(
                            context,
                            it.apiResponseModel[i].state.toString(),
                            Toast.LENGTH_SHORT
                        ).show()

                        tvAffectedToday.text = it.apiResponseModel[i].positiveCasesViral.toString()
                        tvRecoveredToday.text = it.apiResponseModel[i].negative.toString()
                        tvDeathToday.text = it.apiResponseModel[i].death.toString()
                        tvActiveToday.text = it.apiResponseModel[i].hospitalizedCurrently.toString()
                        tvSeriousToday.text = it.apiResponseModel[i].positive.toString()
                    }
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