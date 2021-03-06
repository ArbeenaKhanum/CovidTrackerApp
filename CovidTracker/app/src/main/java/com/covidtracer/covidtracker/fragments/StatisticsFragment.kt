package com.covidtracer.covidtracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import com.covidtracer.covidtracker.R
import com.covidtracer.covidtracker.adapter.TabPagerAdapter
import kotlinx.android.synthetic.main.fragment_statistics.*

class StatisticFragment : Fragment() {
    lateinit var tabPagerAdapter: TabPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPagerAdapter()
        setViewPager()

    }

    private fun setViewPagerAdapter() {
        tabPagerAdapter = TabPagerAdapter(
            childFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
    }

    fun setViewPager() {
        viewPager.adapter = tabPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}