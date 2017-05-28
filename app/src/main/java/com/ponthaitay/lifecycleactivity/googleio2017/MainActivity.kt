package com.ponthaitay.lifecycleactivity.googleio2017

import android.location.Location
import android.os.Bundle
import android.util.Log

class MainActivity : BaseLifecycleActivity() {

    private val TAG = javaClass.simpleName

    var locationManager: LocationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        locationManager = LocationManager(this, lifecycle, object : LocationManager.MyLocationListener {
            override fun locationChange(location: Location) {
                Log.e(TAG, "$location")
            }
        })
    }
}