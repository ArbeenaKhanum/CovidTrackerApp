package com.example.covidtracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.covidtracker.fragments.AppInfoFragment
import com.example.covidtracker.fragments.DataFragment
import com.example.covidtracker.fragments.HomeFragment
import com.example.covidtracker.fragments.StatisticFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openHomePage()

        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)

        val mOnNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.home_page -> {
                        openHomePage()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.statsPage -> {
                        openStatasticPage()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.data -> {
                        openDataPage()
                        return@OnNavigationItemSelectedListener true
                    }

                    R.id.info -> {
                        openAppInfo()
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            }

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun openAppInfo() {
        val appInfoFragment = AppInfoFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer, appInfoFragment, "AppInfoFragment")
            .commit()
    }

    private fun openDataPage() {
        val dataFragment = DataFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer, dataFragment, "DataFragment")
            .commit()
    }

    private fun openStatasticPage() {
        val statasticFragment = StatisticFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer, statasticFragment, "StatasticFragment")
            .commit()
    }

    private fun openHomePage() {
        val homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer, homeFragment, "HomeFragment")
            .commit()
    }
}