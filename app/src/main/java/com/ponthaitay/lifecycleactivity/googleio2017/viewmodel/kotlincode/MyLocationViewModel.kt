package com.ponthaitay.lifecycleactivity.googleio2017.viewmodel.kotlincode

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper

open class MyLocationViewModel : ViewModel(), LocationListener {

    var mutableLiveDataLocation: MutableLiveData<Location>? = null
    var locationManager: LocationManager? = null

    fun getLiveDataLocation(context: Context): LiveData<Location> {
        setupLocationManager(context)
        mutableLiveDataLocation = MutableLiveData()
        return mutableLiveDataLocation as MutableLiveData<Location>
    }

    @SuppressLint("MissingPermission")
    private fun setupLocationManager(context: Context) {
        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationManager?.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10f, this, Looper.getMainLooper())
        locationManager?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 10f, this, Looper.getMainLooper())
    }

    override fun onLocationChanged(location: Location?) {
        mutableLiveDataLocation?.value = location
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderEnabled(provider: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderDisabled(provider: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}