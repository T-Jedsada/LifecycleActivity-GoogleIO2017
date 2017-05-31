package com.ponthaitay.lifecycleactivity.googleio2017.room.kotlincode

import android.os.Bundle
import com.ponthaitay.lifecycleactivity.googleio2017.R


class MainRoomActivity : BaseLifecycleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_room)

//        StudentData db = Room . databaseBuilder getContext(), FeedDatabase::class.java!!, "feed").build()
    }
}
