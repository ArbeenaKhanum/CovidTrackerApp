package com.covidtracer.covidtracker.listerners

import android.os.Bundle

interface StateDataFragmentListener {
    fun onStateDataPassed(bundle: Bundle)
}