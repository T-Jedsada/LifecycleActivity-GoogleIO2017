package com.ponthaitay.lifecycleactivity.googleio2017.room.javacode;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ponthaitay.lifecycleactivity.googleio2017.R;

public class MainRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_room);

        StudentDatabase db = Room.databaseBuilder(this, StudentDatabase.class, "studentdata").build();
        db.queryStudent(5);
    }
}
