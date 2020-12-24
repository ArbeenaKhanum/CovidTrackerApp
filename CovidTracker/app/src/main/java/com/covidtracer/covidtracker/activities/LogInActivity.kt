package com.covidtracer.covidtracker.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import com.covidtracer.covidtracker.R
import com.covidtracer.covidtracker.sharedpreferences.LoginManager
import kotlinx.android.synthetic.main.activity_log_in.*


class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        password.setOnEditorActionListener(OnEditorActionListener { textView, id, keyEvent ->
            if (id == R.id.password || id == EditorInfo.IME_NULL) {
                attemptLogin()
                return@OnEditorActionListener true
            }
            false
        })

        email_sign_in_button.setOnClickListener {
                attemptLogin()
        }

        if (!LoginManager(this).isUserLoggedOut()) {
            startHomeActivity();
        }
    }

    private fun attemptLogin() {
        tvEmail.error = null
        password.error = null

        val emailString: String = tvEmail.text.toString()
        val passwordString: String = password.text.toString()

        var cancel = false
        var focusView: View? = null


        if (!TextUtils.isEmpty(passwordString) && !isPasswordValid(passwordString)) {
            password.error = getString(R.string.invalid_password)
            focusView = password
            cancel = true
        }

        if (TextUtils.isEmpty(emailString)) {
            tvEmail.error = getString(R.string.required_email)
            focusView = tvEmail
            cancel = true
        } else if (!isEmailValid(emailString)) {
            tvEmail.error = getString(R.string.invalid_email)
            focusView = tvEmail
            cancel = true
        }

        if (cancel) {
            focusView?.requestFocus()
        } else {
            if (checkBoxRememberMe.isChecked) saveLoginDetails(emailString, passwordString)
            startHomeActivity()
        }
    }

    private fun startHomeActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun saveLoginDetails(email: String, password: String) {
        LoginManager(this).saveLoginDetails(email, password)
    }

    private fun isEmailValid(email: String): Boolean {
        return email.contains("@")
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 4
    }
}