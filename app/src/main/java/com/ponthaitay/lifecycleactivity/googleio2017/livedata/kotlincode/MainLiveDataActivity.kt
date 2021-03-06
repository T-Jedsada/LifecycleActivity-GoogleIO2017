package com.ponthaitay.lifecycleactivity.googleio2017.livedata.kotlincode

import android.Manifest
import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.location.Location
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.TextView
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.ponthaitay.lifecycleactivity.googleio2017.R

class MainLiveDataActivity : BaseLifecycleActivity() {

    var container: View? = null
    var tvResult: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_live_data)
        container = findViewById(R.id.container)
        tvResult = findViewById(R.id.tv_result) as TextView?

        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION)
                .withListener(object : MultiplePermissionsListener {
                    @SuppressLint("SetTextI18n")
                    override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                        if (!hasDeniedPermission(report)) {
                            MyLocationManager(this@MainLiveDataActivity).observe(this@MainLiveDataActivity,
                                    Observer<Location> { location ->
                                        tvResult!!.text = "${location?.latitude}" + "/" + "${location?.longitude}"
                                    })
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