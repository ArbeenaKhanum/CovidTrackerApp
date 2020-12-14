package com.example.covidtracker.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.covidtracker.R
import com.example.covidtracker.fragments.*
import com.example.covidtracker.listerners.FragmentListener
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(), FragmentListener {

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

    override fun openStats(state:String) {
        val frag = TodayCountryFragment()
        val bundle = Bundle()
        bundle.putString("data",state)
        frag.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.flContainer, frag).commit()
    }

    var singleBack = false

    override fun onBackPressed() {
        if (singleBack) {
            super.onBackPressed()
            return
        }
        singleBack = true
        Toast.makeText(this, "Click again to exit", Toast.LENGTH_SHORT).show()
        Handler().postDelayed(Runnable { singleBack = false }, 2000)
        val run =
            Runnable { startActivity(Intent(this, ExitActivity::class.java)) }
        val mHandler = Handler()
        mHandler.postAtTime(run, 15000)
        finish()
    }
}