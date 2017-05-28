package com.ponthaitay.lifecycleactivity.googleio2017.java;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.location.Location;
import android.util.Log;

class LocationManager implements LifecycleObserver {

    private static final String TAG = LocationManager.class.getName();
    private boolean enabled = false;
    private Lifecycle lifecycle;
    private MyLocationListener listener;

    interface MyLocationListener {
        void locationChange(Location location);
    }

    LocationManager(Context context, Lifecycle lifecycle, MyLocationListener listener) {
        this.listener = listener;
        this.lifecycle = lifecycle;
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void start() {
        Log.e(TAG, "onStart");
        Location test = new Location("test");
        test.setLatitude(555f);
        test.setLongitude(666f);
        listener.locationChange(test);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void stop() {
        Log.e(TAG, "onStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void cleanup() {
        Log.e(TAG, "destroy");
    }
}
