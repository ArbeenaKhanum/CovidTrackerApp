package com.example.covidtracker.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.covidtracker.fragments.GlobalFragment
import com.example.covidtracker.fragments.MyCountryFragment

class TabPagerAdapter(fm : FragmentManager, behavior : Int) : FragmentStatePagerAdapter(fm, behavior) {
    override fun getItem(position: Int): Fragment {
       when(position) {
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
        return super.getPageTitle(position)
    }

}