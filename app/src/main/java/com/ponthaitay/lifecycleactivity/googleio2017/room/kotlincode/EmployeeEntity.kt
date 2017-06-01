package com.ponthaitay.lifecycleactivity.googleio2017.room.kotlincode

import android.arch.persistence.room.Entity

@Entity
data class EmployeeEntity(var id: Int, var firstName: String, var lastName: String)