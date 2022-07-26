package com.app.asakatsuyaroze

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView.BufferType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.asakatsuyaroze.database.AlarmPattern
import java.io.Serializable


public final class SetAlarm : AppCompatActivity() {

    val alarmPattern: AlarmPattern = intent.getSerializableExtra("alarmPattern") as AlarmPattern

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.set_alarm)
    }



    fun showTimePickerDialog(view: View) {
        Toast.makeText(this, "タップされました。", Toast.LENGTH_SHORT).show()
//        val intent = Intent(applicationContext, AddAlarmPattern::class.java)
//        startActivity(intent)
    }
}