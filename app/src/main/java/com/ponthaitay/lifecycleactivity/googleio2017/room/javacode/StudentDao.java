package com.ponthaitay.lifecycleactivity.googleio2017.room.javacode;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface StudentDao {

    @Insert(onConflict = REPLACE)
    void insertStudent(StudentEntity studentEntity);

    @Query("SELECT * FROM studententity WHERE id = :id")
    Flowable<List<StudentEntity>> queryStudent(int id);
}
