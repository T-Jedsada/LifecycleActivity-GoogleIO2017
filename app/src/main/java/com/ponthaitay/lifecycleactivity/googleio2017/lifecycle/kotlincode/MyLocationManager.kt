package com.ponthaitay.lifecycleactivity.googleio2017.lifecycle.kotlincode

import android.annotation.SuppressLint
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper.getMainLooper

class MyLocationManager(context: Context, private val lifecycle: Lifecycle, val listener: MyLocationManager.MyLocationListener) :
        LifecycleObserver, LocationListener {

    interface MyLocationListener {
        fun onLocationChange(location: android.location.Location?)
        fun onProviderDisabled(msg: String?)
        fun onProviderEnabled(provider: String?)
    }

    init {
        lifecycle.addObserver(this)
        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    companion object {
        var enabled: Boolean = false
        var locationManager: LocationManager? = null
    }

    fun locationEnable() {
        if (!enabled) {
            enabled = true
            start()
        }
    }

    @SuppressLint("MissingPermission")
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        if (enabled) {
            locationManager?.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10f, this, getMainLooper())
            locationManager?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 10f, this, getMainLooper())
        }
    }

    @SuppressLint("MissingPermission")
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        locationManager?.removeUpdates(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun cleanup() {
        lifecycle.removeObserver(this)
    }

    override fun onLocationChanged(location: Location?) {
        listener.onLocationChange(location)
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderEnabled(provider: String?) {
        listener.onProviderEnabled(provider)
    }

    override fun onProviderDisabled(provider: String?) {
        listener.onProviderDisabled(provider)
    }
}