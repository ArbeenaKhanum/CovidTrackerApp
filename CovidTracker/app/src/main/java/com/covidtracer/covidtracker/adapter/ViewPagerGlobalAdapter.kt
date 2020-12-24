package com.covidtracer.covidtracker.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.covidtracer.covidtracker.fragments.*

class ViewPagerGlobalAdapter(fragmentManager: FragmentManager, behavior: Int) :
    FragmentPagerAdapter(fragmentManager, behavior) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return TotalGlobalFragment()
            }

            1 -> {
                return TodayGlobalFragment()
            }

            2 -> {
                return YesterdayGlobalFragment()
            }
            else -> {
                return TotalGlobalFragment()
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