package com.ponthaitay.lifecycleactivity.googleio2017.livedata.kotlincode

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.support.v7.app.AppCompatActivity

open class BaseLifecycleActivity : AppCompatActivity(), LifecycleRegistryOwner {

    @Suppress("LeakingThis")
    private val mRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry  = mRegistry
}