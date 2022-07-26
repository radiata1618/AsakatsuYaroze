package com.app.asakatsuyaroze

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

//    val floatingActionButton = findViewById<FloatingActionButton>(R.id.floating_action_button)
//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    fun floatingActionButtonClick(view: View) {
//        Toast.makeText(this, "タップされました。", Toast.LENGTH_SHORT).show()
        val intent = Intent(applicationContext, AddAlarmPattern::class.java)
        startActivity(intent)
    }

}