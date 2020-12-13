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
import com.example.covidtracker.viewmodel.StateListDataViewModel
import com.example.covidtracker.viewmodel.StatesViewModel
import com.example.covidtracker.viewmodelfactory.StatesViewModelFactory
import kotlinx.android.synthetic.main.fragment_country_total.*

class TotalCountryFragment : Fragment() {

    private lateinit var statesListDataViewModel: StateListDataViewModel
    lateinit var statesViewModel : StatesViewModel

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
        val totalCountryFragment = TotalCountryFragment()
        val bundle = Bundle()
        totalCountryFragment.arguments = bundle;
        bundle.getString("stateData");
        statesViewModel =
            StatesViewModelFactory(this.requireContext(), requireActivity()).create(StatesViewModel::class.java)
        statesListDataViewModel = ViewModelProvider(requireActivity()).get(StateListDataViewModel::class.java)
//
//        val state : String = arguments?.getString("stateData").toString()
        getStateFromViewModel()
        observeLiveStatesDetailsData()

    }

    private fun getStateFromViewModel() {
        statesViewModel.stateData.observe(this, Observer {
            statesListDataViewModel.stateDataDetails(it)
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
    }

     private fun observeLiveStatesDetailsData() {
        statesListDataViewModel.liveDataOfState.observe(this, Observer {
            when (it) {

                is StateDataUIModel.Success -> {
//                    it.apiResponseModel
                    for (i in 0 until it.apiResponseModel.size) {
                        tvSeriousTotal.text =
                            it.apiResponseModel[i].totalTestResultsIncrease.toString()
                        tvRecoveredTotal.text = it.apiResponseModel[i].posNeg.toString()
                        tvDeathTotal.text = it.apiResponseModel[i].death.toString()
                        tvActiveTotal.text = it.apiResponseModel[i].totalTestsViral.toString()
                        tvAffectedTotal.text = it.apiResponseModel[i].total.toString()
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