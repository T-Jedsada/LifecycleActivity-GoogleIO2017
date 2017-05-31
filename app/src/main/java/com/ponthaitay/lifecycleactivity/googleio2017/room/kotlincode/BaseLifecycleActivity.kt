package com.ponthaitay.lifecycleactivity.googleio2017.room.kotlincode

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.support.v7.app.AppCompatActivity


open class BaseLifecycleActivity : AppCompatActivity(), LifecycleRegistryOwner {

    @Suppress("LeakingThis")
    private var mRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry = mRegistry
}