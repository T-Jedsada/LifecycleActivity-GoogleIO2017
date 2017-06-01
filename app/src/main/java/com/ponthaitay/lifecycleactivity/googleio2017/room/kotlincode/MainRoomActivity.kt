package com.ponthaitay.lifecycleactivity.googleio2017.room.kotlincode

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
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
        val dao = employeeDB?.employeeDao()

        val jedsadaEmpolyee = EmployeeEntity()
        jedsadaEmpolyee.firstName = "test"
        jedsadaEmpolyee.lastName = "test"

        val employeeModel = ViewModelProviders.of(this).get(EmployeeViewModel::class.java)

        employeeModel.insertStudent(dao, jedsadaEmpolyee)
        employeeModel.getStudentById(dao, jedsadaEmpolyee.firstName)
                .observe(this, Observer { setResultQueryEmployee(it) })
    }

    fun setResultQueryEmployee(list: List<EmployeeEntity>?) {
        Log.d(TAG, "$list")
    }
}