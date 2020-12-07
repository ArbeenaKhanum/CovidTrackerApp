package com.example.covidtracker.fragments

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.covidtracker.R
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.jar.Manifest


class HomeFragment : Fragment() {
    val PhoneCallRequestCode: Int = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    private fun initViews(view: View) {
        callNow.setOnClickListener {
            checkForPermission()
        }

        sendSms.setOnClickListener {
            sendSMS()
        }
    }

    private fun sendSMS() {
        val uri = Uri.parse("smsto:1234567890")
        val smsIntent = Intent(Intent.ACTION_SENDTO, uri)

        smsIntent.putExtra(
            "sms",
            "Hey, Experienced covid positive symptoms. Need immediate assistance!!"
        )
        startActivity(smsIntent)
    }

    private fun checkForPermission() {

        if (context?.let {
                ContextCompat.checkSelfPermission(
                    it,
                    android.Manifest.permission.CALL_PHONE
                )
            } !=
            PackageManager.PERMISSION_GRANTED) {
            if (activity?.let {
                    ActivityCompat.shouldShowRequestPermissionRationale(
                        it,
                        android.Manifest.permission.CALL_PHONE
                    )
                }!!) {

            } else {
                ActivityCompat.requestPermissions(
                    activity!!,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    101
                )
            }
        } else {
            callHelpLine()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 101) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                callHelpLine()
            } else {

            }
            return
        }
    }

    private fun callHelpLine() {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:1234567890")
        startActivity(callIntent)
    }
}