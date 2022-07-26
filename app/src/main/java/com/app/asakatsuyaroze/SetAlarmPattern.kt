package com.app.asakatsuyaroze

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView.BufferType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.asakatsuyaroze.database.AlarmPattern
import java.io.Serializable


public final class SetAlarmPattern : AppCompatActivity() {

    val alarmPattern:AlarmPattern = intent.getSerializableExtra("alarmPattern") as AlarmPattern
    val editText:EditText = findViewById<EditText>(R.id.textAlarmPatternName)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.set_alarm_pattern)
        editText.setText(alarmPattern.patternName, BufferType.NORMAL)
    }


    fun floatingActionButtonClick(view: View) {
        Toast.makeText(this, "タップされました。", Toast.LENGTH_SHORT).show()
//        val intent = Intent(applicationContext, AddAlarmPattern::class.java)
//        startActivity(intent)
    }
}