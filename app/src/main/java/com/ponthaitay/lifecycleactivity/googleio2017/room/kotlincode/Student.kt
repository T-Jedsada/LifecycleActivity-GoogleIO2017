package com.ponthaitay.lifecycleactivity.googleio2017.room.kotlincode

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Query

@Entity
data class StudentData(var id: Int, var firstName: String, var lastName: String)

@Dao
interface StudentQuery {
    @Query("SELECT * FROM stud WHERE kkkkk = :id")
    fun querySutdent(id: Int): List<StudentData>
}