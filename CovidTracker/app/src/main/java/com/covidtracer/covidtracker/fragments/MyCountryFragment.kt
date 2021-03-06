package com.covidtracer.covidtracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import com.covidtracer.covidtracker.R
import com.covidtracer.covidtracker.adapter.ViewPagerCountryAdapter
import kotlinx.android.synthetic.main.fragment_my_country.*

class MyCountryFragment : Fragment() {
    lateinit var viewPagerCountryAdapter: ViewPagerCountryAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_country, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPagerAdapterDetails(view)
        setViewPagerDetails(view)
    }

    fun setViewPagerAdapterDetails(view: View) {
        viewPagerCountryAdapter = ViewPagerCountryAdapter(
            childFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
    }

    fun setViewPagerDetails(view: View) {
        viewPagerDetails.adapter = viewPagerCountryAdapter
        tabLayoutDetails.setupWithViewPager(viewPagerDetails)
    }
}