package com.ponthaitay.lifecycleactivity.googleio2017.room.javacode;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.ponthaitay.lifecycleactivity.googleio2017.R;

import java.util.List;

public class MainRoomActivity extends BaseLifecycleActivity {

    private StudentViewModel studentViewModel;
    private LiveData<List<StudentEntity>> result;

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_room);

        final StudentDatabase db = Room.databaseBuilder(this, StudentDatabase.class, "student_db").build();

        final StudentEntity entity = new StudentEntity();
        entity.setId(1);
        entity.setFirstName("Test");
        entity.setLastName("test");

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        studentViewModel.insertStudent(db.student(), entity);
        studentViewModel.getStudentById(db.student(), 1).observe(this, new Observer<List<StudentEntity>>() {
            @Override
            public void onChanged(@Nullable List<StudentEntity> studentEntities) {
                if (studentEntities != null) Log.d("POND", String.valueOf(studentEntities.get(0).getFirstName()));
                else Log.d("POND", "error");
            }
        });
    }
}
