package com.ponthaitay.lifecycleactivity.googleio2017.room.kotlincode

import android.arch.persistence.room.Room
import android.os.Bundle
import android.util.Log
import com.ponthaitay.lifecycleactivity.googleio2017.R


class MainRoomActivity : BaseLifecycleActivity() {

    val TAG: String = javaClass.simpleName
    var employeeDB: EmployeeDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_room)
        employeeDB = Room.databaseBuilder(this, EmployeeDatabase::class.java, "employee_db").build()

        val jedsadaEmpolyee = EmployeeEntity(1, "Jedsada", "Tiwongvorakul")

        employeeDB?.studentDao()?.insertEmployee(jedsadaEmpolyee)
        val studentQuery = employeeDB?.studentDao()?.queryEmployee(1)

        Log.e(TAG, "$studentQuery")
    }
}