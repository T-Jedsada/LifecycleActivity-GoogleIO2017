package com.ponthaitay.lifecycleactivity.googleio2017.viewmodel.kotlincode

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.support.v7.app.AppCompatActivity

open class BaseLifecycleActivity : AppCompatActivity(), LifecycleRegistryOwner {

    private val mRegister = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry {
        return  mRegister
    }
}
