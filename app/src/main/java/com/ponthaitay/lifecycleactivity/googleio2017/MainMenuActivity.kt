package com.ponthaitay.lifecycleactivity.googleio2017

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ponthaitay.lifecycleactivity.googleio2017.lifecycle.kotlincode.MainLifecycleActivity
import com.ponthaitay.lifecycleactivity.googleio2017.livedata.kotlincode.MainLiveDataActivity
import com.ponthaitay.lifecycleactivity.googleio2017.room.kotlincode.MainRoomActivity
import com.ponthaitay.lifecycleactivity.googleio2017.viewmodel.kotlincode.MainViewModelActivity

open class MainMenuActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }

    override fun onClick(v: View?) {
        var intent: Intent? = null
        when (v?.id) {
            R.id.btn_lifecycle_activity -> intent = Intent(this, MainLifecycleActivity::class.java)
            R.id.btn_live_data_activity -> intent = Intent(this, MainLiveDataActivity::class.java)
            R.id.btn_room_activity -> intent = Intent(this, MainRoomActivity::class.java)
            R.id.btn_view_model_activity -> intent = Intent(this, MainViewModelActivity::class.java)
            R.id.btn_mix_activity -> intent = Intent(this, MainLifecycleActivity::class.java)
        }
        startActivity(intent)
    }
}
