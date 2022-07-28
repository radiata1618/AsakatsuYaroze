package com.app.asakatsuyaroze

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


public final class SetAlarmPattern : AppCompatActivity() {


    //    val viewModel: AddAlarmPatternViewModel by viewModels()
    private var editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intentMain = intent
        val alarmPatternId: Int = intentMain.getIntExtra("alarmPatternId", 0)
//        val editText:EditText = findViewById<EditText>(R.id.textAlarmPatternName)
        editText = findViewById<EditText>(R.id.textAlarmPatternName)

//        val viewModel: AddAlarmPatternViewModel by viewModels()

        setContentView(R.layout.set_alarm_pattern)
//        editText.setText(viewModel.alarmPattern?.patternName ?: "", BufferType.NORMAL)
    }


    fun floatingActionButtonClick(view: View) {
        Toast.makeText(this, "タップされました。", Toast.LENGTH_SHORT).show()
//        val intent = Intent(applicationContext, AddAlarmPattern::class.java)
//        startActivity(intent)
    }
}