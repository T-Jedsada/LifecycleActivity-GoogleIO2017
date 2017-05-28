package com.ponthaitay.lifecycleactivity.googleio2017

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.location.Location
import android.util.Log

class LocationManager(context: Context, private val lifecycle: Lifecycle, val listener: MyLocationListener) :
        LifecycleObserver {
    private val enabled = false

    private val TAG = javaClass.simpleName

    interface MyLocationListener {
        fun locationChange(location: Location)
    }

    init {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        Log.e(TAG, "onStart")
        val test = Location("test")
        test.latitude = 555.0
        test.longitude = 666.0
        listener.locationChange(test)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        Log.e(TAG, "onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun cleanup() {
        Log.e(TAG, "destroy")
    }
}