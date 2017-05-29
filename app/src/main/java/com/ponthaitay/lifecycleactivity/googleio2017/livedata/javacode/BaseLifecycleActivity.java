package com.ponthaitay.lifecycleactivity.googleio2017.livedata.javacode;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.support.v7.app.AppCompatActivity;

public class BaseLifecycleActivity extends AppCompatActivity implements LifecycleRegistryOwner {

    private final LifecycleRegistry mRegistry = new LifecycleRegistry(this);

    public BaseLifecycleActivity() {
    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return mRegistry;
    }
}
