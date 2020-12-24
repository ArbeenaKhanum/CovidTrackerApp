package com.covidtracer.covidtracker.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.covidtracer.covidtracker.fragments.GlobalFragment
import com.covidtracer.covidtracker.fragments.MyCountryFragment

class TabPagerAdapter(fm: FragmentManager, behavior: Int) :
    FragmentPagerAdapter(fm, behavior) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return MyCountryFragment()
            }

            1 -> {
                return GlobalFragment()
            }
        }
        return MyCountryFragment()
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return "My Country"
            }

            1 -> {
                return "Global"
            }
        }
        return "My Country"
    }

}