package com.app.asakatsuyaroze

import android.app.Dialog
import android.widget.TimePicker
import android.app.TimePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import androidx.room.Room
import com.app.asakatsuyaroze.data.Alarm
import com.app.asakatsuyaroze.data.AppDatabase
import com.app.asakatsuyaroze.data.SetAlarmPatternViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalTime

class TimePick(mode:Int,patternId:Int,context: Context,mSetAlarmPatternViewModel: SetAlarmPatternViewModel) : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    private val modeValue:Int = mode
    private val patternIdValue:Int = patternId
    private val contextValue:Context = context
    private val mSetAlarmPatternViewModelValue:SetAlarmPatternViewModel=mSetAlarmPatternViewModel

    // Bundle sould be nullable, Bundle?
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // to initialize a Calender instance
        val c = Calendar.getInstance()

        // at the first, to get the system current hour and minute
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        return TimePickerDialog(
            activity,
            // in order to return parameters to MainActivity
            this,
            hour,
            minute,
            true)
    }



    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {

        val database =
            Room.databaseBuilder(contextValue, AppDatabase::class.java, "mainDatabase")
                .build()
        val alarmDao = database.alarmDao()
        when (modeValue) {
            1 -> {
                //朝活目覚ましの処理
                GlobalScope.launch(Dispatchers.IO) {

                    alarmDao.updateAlarmType2Default(patternIdValue,hourOfDay,minute)

                    var time:LocalTime = LocalTime.of(hourOfDay, minute, 0)
                    time=time.minusMinutes(5)

                    alarmDao.updateAlarmType1Default(patternIdValue,time.hour,time.minute)

                    mSetAlarmPatternViewModelValue.refleshData(contextValue,patternIdValue)

                }

            }

            2 -> {

            }
        }

    }
}