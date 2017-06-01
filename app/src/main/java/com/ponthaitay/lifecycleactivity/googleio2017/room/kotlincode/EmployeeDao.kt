package com.ponthaitay.lifecycleactivity.googleio2017.room.kotlincode

import android.arch.persistence.room.*

@Dao
interface EmployeeDao {

    @Insert
    fun insertEmployee(employeeEntity: EmployeeEntity)

    @Delete
    fun deleteEmployee(id: Int)

    @Update
    fun updateEmployee(id: Int)

    @Query("SELECT * FROM stud WHERE kkkkk = :id")
    fun queryEmployee(id: Int): List<EmployeeEntity>
}