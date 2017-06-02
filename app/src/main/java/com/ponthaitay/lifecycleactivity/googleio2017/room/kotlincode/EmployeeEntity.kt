package com.ponthaitay.lifecycleactivity.googleio2017.room.kotlincode

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

//@Entity(tableName = "employee")
//class EmployeeEntity {
//    @PrimaryKey(autoGenerate = true) var id: Int? = null
//    var firstName: String? = null
//    var lastName: String? = null
//}

@Entity(tableName = "employee")
data class EmployeeEntity(
        var name: String?,
        @PrimaryKey var age: Int?) {

    constructor() : this("", 0)
}