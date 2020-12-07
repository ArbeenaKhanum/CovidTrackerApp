package com.example.covidtracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import com.example.covidtracker.R
import com.example.covidtracker.adapter.TabPagerAdapter
import com.example.covidtracker.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_my_country.*
import kotlinx.android.synthetic.main.fragment_statistics.*

class MyCountryFragment : Fragment() {
    lateinit var viewPagerAdapter: ViewPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_country, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPagerAdapterDetails()
        setViewPagerDetails()
    }

    fun setViewPagerAdapterDetails() {
        viewPagerAdapter = ViewPagerAdapter(
            childFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
    }

    fun setViewPagerDetails() {
        viewPagerDetails.adapter = viewPagerAdapter
        tabLayoutDetails.setupWithViewPager(viewPagerDetails)
    }
}