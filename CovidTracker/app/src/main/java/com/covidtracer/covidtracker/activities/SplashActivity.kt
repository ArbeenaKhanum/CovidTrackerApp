package com.covidtracer.covidtracker.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.covidtracer.covidtracker.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val runnable = Runnable {
            val startIntent = Intent(this, LogInActivity::class.java)
            startActivity(startIntent)
            finish()
        }

        val handler = Handler()
        handler.postDelayed(runnable, 3000)
    }
}