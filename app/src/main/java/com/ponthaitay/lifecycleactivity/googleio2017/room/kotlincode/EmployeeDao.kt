package com.ponthaitay.lifecycleactivity.googleio2017.room.kotlincode

import android.arch.persistence.room.*
import io.reactivex.Flowable

@Dao
interface EmployeeDao {

    @Insert
    fun insertEmployee(employeeEntity: EmployeeEntity)

    @Delete
    fun deleteEmployee(id: Int)

    @Update
    fun updateEmployee(id: Int)

    @Query("SELECT * FROM employee " +
            "WHERE employee.firstName = :arg0")
    fun queryEmployee(firstName: String?): Flowable<List<EmployeeEntity>>
}