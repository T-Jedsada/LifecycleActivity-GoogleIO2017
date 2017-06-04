package com.ponthaitay.lifecycleactivity.googleio2017.room.kotlincode

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Update

@Dao
interface EmployeeDao {

//    @Insert
//    fun insertEmployee(employeeEntity: EmployeeEntity)

    @Delete
    fun deleteEmployee(id: Int)

    @Update
    fun updateEmployee(id: Int)
//    @Query("SELECT * FROM employee")
//    fun queryEmployee(): Flowable<List<EmployeeEntity>>
}