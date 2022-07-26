package com.app.asakatsuyaroze

import AlarmPatternSerializable
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.app.asakatsuyaroze.database.AlarmPattern
import com.app.asakatsuyaroze.database.AppDatabase

public final class AddAlarmPattern : AppCompatActivity() {

    val editText = findViewById<EditText>(R.id.textAlarmPatternName)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_alarm_pattern)
    }


    fun registerButtonOnClick(view: View) {
//        Toast.makeText(this, "タップされました。", Toast.LENGTH_SHORT).show()
        val database =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database-name")
                .build()
        val alarmPatternDao = database.alarmPatternDao()
        val newAlarmPattern:AlarmPattern = AlarmPattern(
            0,
            editText.text.toString(),
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            0,
            0,
            false
        )
        alarmPatternDao.insert(newAlarmPattern)
        Log.v("TAG", "after insert ${alarmPatternDao.getAll().toString()}")
        val intent = Intent(applicationContext, SetAlarmPattern::class.java)

        val alarmPatternSerializable:AlarmPatternSerializable=AlarmPatternSerializable(newAlarmPattern)
        intent.putExtra("alarmPattern",alarmPatternSerializable)
        startActivity(intent)

    }


}

