package com.covidtracer.covidtracker.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.covidtracer.covidtracker.fragments.TodayCountryFragment
import com.covidtracer.covidtracker.fragments.TotalCountryFragment
import com.covidtracer.covidtracker.fragments.YesterdayCountryFragment

class ViewPagerCountryAdapter(fragmentManager: FragmentManager, behavior: Int) :
    FragmentPagerAdapter(fragmentManager, behavior) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return TotalCountryFragment()
            }

            1 -> {
                return TodayCountryFragment()
            }

            2 -> {
                return YesterdayCountryFragment()
            }
            else -> {
                return TotalCountryFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 3;
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return "Total"
            }

            1 -> {
                return "Today"
            }

            2 -> {
                return "Yesterday"
            }
        }
        return super.getPageTitle(position)
    }
}