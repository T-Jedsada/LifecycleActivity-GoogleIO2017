package com.ponthaitay.lifecycleactivity.googleio2017.java;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.ponthaitay.lifecycleactivity.googleio2017.R;

public class MainActivity extends BaseLifecycleActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "test");
        new LocationManager(this, getLifecycle(), new LocationManager.MyLocationListener() {
            @Override
            public void locationChange(Location location) {
                Log.e(TAG, "test");
            }
        });
    }
}
