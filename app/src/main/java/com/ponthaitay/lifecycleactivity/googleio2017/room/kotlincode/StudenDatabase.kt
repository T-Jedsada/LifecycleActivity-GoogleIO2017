package com.ponthaitay.lifecycleactivity.googleio2017.room.kotlincode

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(StudentData::class), version = 1)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun studentData(): StudentData
}