package com.covidtracer.covidtracker.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.covidtracer.covidtracker.R

class SplashActivity : AppCompatActivity() {
    private val TAG = SplashActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        printLogs("onCreate")

        val runnable = Runnable {
            val startIntent = Intent(this, LogInActivity::class.java)
            startActivity(startIntent)
            finish()
        }

        val handler = Handler()
        handler.postDelayed(runnable, 3000)
    }

    override fun onStart() {
        super.onStart()
        printLogs("onStart")
    }

    override fun onResume() {
        super.onResume()
        printLogs("onResume")
    }

    override fun onPause() {
        super.onPause()
        printLogs("onPause")
    }

    override fun onStop() {
        super.onStop()
        printLogs("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        printLogs("onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        printLogs("onRestart")
    }

    private fun printLogs(message: String) {
        Log.d(TAG, message)
    }
}