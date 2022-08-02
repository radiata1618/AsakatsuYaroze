package com.app.asakatsuyaroze

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.asakatsuyaroze.adapter.MainActivityAdapter
import com.app.asakatsuyaroze.data.Alarm
import com.app.asakatsuyaroze.data.AlarmPattern
import com.app.asakatsuyaroze.data.MainActivityViewModel
import com.app.asakatsuyaroze.data.SetAlarmPatternViewModel
import com.app.asakatsuyaroze.databinding.ActivityMainBinding

public final class SetAlarmPattern : AppCompatActivity() {

    private var alarmPatternId:Int =0;
    private lateinit var mSetAlarmPatternViewModel: SetAlarmPatternViewModel

    override fun onStart() {
        super.onStart()
        mSetAlarmPatternViewModel.refleshData(applicationContext,alarmPatternId)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.set_alarm_pattern)

        mSetAlarmPatternViewModel =
            ViewModelProvider(this).get(SetAlarmPatternViewModel::class.java)

        alarmPatternId = intent.getIntExtra("alarmPatternId", -1)

        mSetAlarmPatternViewModel.alarmPattern.observe(this) {
            if(mSetAlarmPatternViewModel.alarmPattern.value!=null){
                findViewById<EditText>(R.id.textAlarmPatternName).setText(mSetAlarmPatternViewModel.alarmPattern.value!!.patternName)
            }
        }

        mSetAlarmPatternViewModel.alarmListType1.observe(this) {
            if(mSetAlarmPatternViewModel.alarmListType1.value!!.size!=0){
                val alarmType1: Alarm =mSetAlarmPatternViewModel.alarmListType1.value!![0]
                findViewById<TextView>(R.id.textViewAlarmFirstTime).setText(alarmType1.hour.toString()+":"+alarmType1.minute.toString())
            }
        }

        mSetAlarmPatternViewModel.alarmListType2.observe(this) {
            if(mSetAlarmPatternViewModel.alarmListType2.value!!.size!=0){
                val alarmType2: Alarm =mSetAlarmPatternViewModel.alarmListType2.value!![0]
                findViewById<TextView>(R.id.textViewAlarmSecondTime).setText(alarmType2.hour.toString()+":"+alarmType2.minute.toString())
            }
        }

        mSetAlarmPatternViewModel.alarmListType3.observe(this) {
        }

    }
    fun firstSecondAlarmSetButtonClick(view: View) {

        val newFragment = TimePick(1,alarmPatternId,this,mSetAlarmPatternViewModel)
        newFragment.show(supportFragmentManager, "timePicker")

    }

    fun floatingActionButtonClick(view: View) {
        Toast.makeText(this, "タップされました。", Toast.LENGTH_SHORT).show()
    }
}