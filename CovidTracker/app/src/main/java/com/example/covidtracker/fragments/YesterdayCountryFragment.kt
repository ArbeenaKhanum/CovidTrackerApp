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
import kotlinx.android.synthetic.main.fragment_country_total.*
import kotlinx.android.synthetic.main.fragment_country_yesterday.*

class YesterdayCountryFragment : Fragment() {
    private lateinit var statesDataViewModel: StateDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_yesterday, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statesDataViewModel = ViewModelProvider(this).get(StateDataViewModel::class.java)
//        var bundle = Bundle()
        val state : String = arguments?.getString("stateData").toString()
        observeLiveStatesYesterdayData()
        statesDataViewModel.stateData("ca")
    }

    private fun observeLiveStatesYesterdayData() {
        statesDataViewModel.liveDataOfState.observe(this, Observer {
            when (it) {

                is StateDataUIModel.Success -> {
                    it.apiResponseModel

                    tvSeriousYesterday.text = it.apiResponseModel[2].positiveCasesViral.toString()
                    tvRecoveredYesterday.text = it.apiResponseModel[2].negative.toString()
                    tvDeathYesterday.text = it.apiResponseModel[2].death.toString()
                    tvActiveYesterday.text = it.apiResponseModel[2].hospitalizedCurrently.toString()
                    tvAffectedYesterday.text = it.apiResponseModel[2].positive.toString()
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