package com.app.asakatsuyaroze

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.app.asakatsuyaroze.database.AlarmPattern
import com.app.asakatsuyaroze.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

public final class SetAlarmPattern : AppCompatActivity() {


    private var editText: EditText? = null
    private var alarmPattern: AlarmPattern? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intentMain = intent
        val alarmPatternId: Int = intentMain.getIntExtra("alarmPatternId", -1)

        editText = findViewById<EditText>(R.id.textAlarmPatternName)
        setContentView(R.layout.set_alarm_pattern)

        val database =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "mainDatabase")
                .build()
        val alarmPatternDao = database.alarmPatternDao()


        GlobalScope.launch(Dispatchers.IO) {
            alarmPattern=alarmPatternDao.getAlarmPattern(alarmPatternId)
        }

    }


    fun floatingActionButtonClick(view: View) {
        Toast.makeText(this, "タップされました。", Toast.LENGTH_SHORT).show()
//        val intent = Intent(applicationContext, AddAlarmPattern::class.java)
//        startActivity(intent)
    }
}