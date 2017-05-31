package com.ponthaitay.lifecycleactivity.googleio2017.room.javacode;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface StudentDao {

    @Query("SELECT * FROM studentdata WHERE iddd = :id")
    List<StudentData> queryStudent(int id);
}
