package com.app.asakatsuyaroze

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.asakatsuyaroze.adapter.MainActivityAdapter
import com.app.asakatsuyaroze.data.AlarmPattern
import com.app.asakatsuyaroze.data.SetAlarmPatternViewModel
import com.app.asakatsuyaroze.databinding.ActivityMainBinding

public final class SetAlarmPattern : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.set_alarm_pattern)

        val mSetAlarmPatternViewModel =
            ViewModelProvider(this).get(SetAlarmPatternViewModel::class.java)

        val alarmPatternId: Int = intent.getIntExtra("alarmPatternId", -1)
        mSetAlarmPatternViewModel.refleshData(applicationContext,alarmPatternId)

        mSetAlarmPatternViewModel.alarmPattern.observe(this) {
            if(mSetAlarmPatternViewModel.alarmPattern.value!=null){
                findViewById<EditText>(R.id.textAlarmPatternName).setText(mSetAlarmPatternViewModel.alarmPattern.value!!.patternName)
            }
        }

        mSetAlarmPatternViewModel.alarmList.observe(this) {
        }


    }

    fun floatingActionButtonClick(view: View) {
        Toast.makeText(this, "タップされました。", Toast.LENGTH_SHORT).show()
//        val intent = Intent(applicationContext, AddAlarmPattern::class.java)
//        startActivity(intent)
    }
}