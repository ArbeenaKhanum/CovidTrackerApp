package com.covidtracer.covidtracker.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.covidtracer.covidtracker.R
import kotlinx.android.synthetic.main.activity_logout.*


class LogoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAnimation();
        setContentView(R.layout.activity_logout)

        val sharedPreferences = getSharedPreferences("LoginDetails", MODE_PRIVATE);
        tvUsername.text = sharedPreferences.getString("Email", null)

        ivLogout.setOnClickListener {
            intent = Intent(this, LogInActivity::class.java)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            startActivity(intent)
        }
    }

    private fun setAnimation() {
        if (Build.VERSION.SDK_INT > 20) {
            val slide = Slide();
            slide.slideEdge = Gravity.LEFT;
            slide.duration = 400;
            slide.interpolator = DecelerateInterpolator();
            window.exitTransition = slide;
            window.enterTransition = slide;
        }
    }
}