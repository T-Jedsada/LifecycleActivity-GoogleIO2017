package com.ponthaitay.lifecycleactivity.googleio2017.room.javacode;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {StudentData.class}, version = 1)
abstract class StudentDatabase extends RoomDatabase {

    abstract StudentDao queryStudent(int id);
}
