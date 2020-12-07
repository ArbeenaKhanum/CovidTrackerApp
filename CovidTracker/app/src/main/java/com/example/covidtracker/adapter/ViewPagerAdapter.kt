package com.example.covidtracker.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.covidtracker.fragments.TodayFragment
import com.example.covidtracker.fragments.TotalFragment
import com.example.covidtracker.fragments.YesterdayFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, behavior: Int) :
    FragmentPagerAdapter(fragmentManager, behavior) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return TotalFragment()
            }

            1 -> {
                return TodayFragment()
            }

            2 -> {
                return YesterdayFragment()
            }
            else -> {
                return TotalFragment()
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