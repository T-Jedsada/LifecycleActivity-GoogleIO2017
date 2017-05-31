package com.ponthaitay.lifecycleactivity.googleio2017.lifecycle.kotlincode

import android.Manifest
import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.widget.TextView
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.ponthaitay.lifecycleactivity.googleio2017.R


class MainActivity : BaseLifecycleActivity() {

    var locationManager: MyLocationManager? = null
    var container: android.view.View? = null
    var TAG: String = javaClass.simpleName
    var tvResult: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_lifecycle)
        container = findViewById(R.id.container)
        tvResult = findViewById(R.id.tv_result) as TextView?
        locationManager = MyLocationManager(this, lifecycle, object : MyLocationManager.MyLocationListener {
            override fun onProviderDisabled(msg: String?) {
                Log.d(TAG, "{$msg}")
            }

            override fun onProviderEnabled(provider: String?) {
                Log.d(TAG, "{$provider}")
            }

            @SuppressLint("SetTextI18n")
            override fun onLocationChange(location: Location?) {
                Log.d(TAG, "{$location}")
                tvResult!!.text = "${location?.latitude}" + "/" + "${location?.longitude}"
            }
        })

        checkPermissionLocation()
    }

    private fun checkPermissionLocation() {
        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION)
                .withListener(object : MultiplePermissionsListener {
                    override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                        if (!hasDeniedPermission(report)) {
                            locationManager!!.locationEnable()
                        } else {
                           Snackbar.make(container!!, report.toString(), Snackbar.LENGTH_SHORT).show()
                        }
                    }

                    override fun onPermissionRationaleShouldBeShown(permissions: MutableList<PermissionRequest>, token: PermissionToken) {
                        token.continuePermissionRequest()
                    }

                    private fun hasDeniedPermission(report: MultiplePermissionsReport?): Boolean {
                        return report?.deniedPermissionResponses?.size!! > 0
                    }

                }).check()
    }
}