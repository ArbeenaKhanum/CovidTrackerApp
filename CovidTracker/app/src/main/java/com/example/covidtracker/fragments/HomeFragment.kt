package com.example.covidtracker.fragments

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covidtracker.R
import com.example.covidtracker.UIModel.StatesUIModel
import com.example.covidtracker.adapter.StatesAdapter
import com.example.covidtracker.listerners.StatesRecyclerViewItemClick
import com.example.covidtracker.model.StatesResponseModel
import com.example.covidtracker.viewmodel.StatesViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_states.*


class HomeFragment : Fragment(), StatesRecyclerViewItemClick{
    val PhoneCallRequestCode: Int = 101
    private lateinit var statesViewModel: StatesViewModel
    private lateinit var statesAdapter: StatesAdapter
    private val statesResponseList = emptyList<StatesResponseModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)

        var country = spinner.selectedCountryName
        country = "USA"
    }

    private fun initViews(view: View) {
        callNow.setOnClickListener {
            checkForPermission()
        }

        sendSms.setOnClickListener {
            sendSMS()
        }

        statesViewModel = ViewModelProvider(this).get(StatesViewModel::class.java)
        setRecyclerStateData()
        observeLiveData()
        statesViewModel.statesApiCall()


//        spinnerSelection(view)

//        tvCovid19.setOnClickListener {
//            viewListOfStates(view)
//        }
    }

    private fun observeLiveData() {
        statesViewModel.liveData.observe(this, Observer {
            when (it) {
                is StatesUIModel.Success -> {
                    statesAdapter.updateStatesList(statesResponseList)
                }

                is StatesUIModel.Failure -> {
                    Toast.makeText(
                        context,
                        "Error message ${it.error}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    private fun setRecyclerStateData() {
        statesAdapter = StatesAdapter(statesResponseList,this)
        val layoutManager = LinearLayoutManager(context)
        rlListOfStates.apply {
            this.layoutManager = layoutManager
            adapter = statesAdapter
        }
    }

    private fun sendSMS() {
        val uri = Uri.parse("smsto:1234567890")
        val smsIntent = Intent(Intent.ACTION_SENDTO, uri)

        smsIntent.putExtra(
            "sms",
            "Hey, Experienced covid positive symptoms. Need immediate assistance!!"
        )
        startActivity(smsIntent)
    }

    private fun checkForPermission() {

        if (context?.let {
                ContextCompat.checkSelfPermission(
                    it,
                    android.Manifest.permission.CALL_PHONE
                )
            } !=
            PackageManager.PERMISSION_GRANTED) {
            if (activity?.let {
                    ActivityCompat.shouldShowRequestPermissionRationale(
                        it,
                        android.Manifest.permission.CALL_PHONE
                    )
                }!!) {

            } else {
                ActivityCompat.requestPermissions(
                    activity!!,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    101
                )
            }
        } else {
            callHelpLine()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 101) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                callHelpLine()
            } else {

            }
            return
        }
    }

    private fun callHelpLine() {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:1234567890")
        startActivity(callIntent)
    }

    override fun onStateClicked(statesResponse: StatesResponseModel, position: Int) {
        TODO("Not yet implemented")
    }

    //    private fun viewListOfStates(view: View) {
//        openStatesFragment(view)
//    }

//    private fun openStatesFragment(view: View) {
//        val statesFragment = StatesFragment()
//        fragmentManager?.beginTransaction()
//            ?.add(R.id.flStatesFragment, statesFragment, "statesFragment")
//            ?.commit()
//    }

//    private fun spinnerSelection(view: View) {
//        val countryList = ArrayList<String>()
//        countryList.add("USA")
//        countryList.add("INDIA")
//        countryList.add("EUROPE")
//        countryList.add("AUSTRALIA")
//
//        val arrayAdapter = context?.let { ArrayAdapter<String>(it, R.layout.support_simple_spinner_dropdown_item, countryList) }
//        spinner.adapter = arrayAdapter
//    }

}