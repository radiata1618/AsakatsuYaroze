package com.app.asakatsuyaroze.data

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SetAlarmPatternViewModel(application: Application) : AndroidViewModel(application) {

    var alarmPattern = MutableLiveData<AlarmPattern>()
    var alarmList = MutableLiveData<List<Alarm>>()

    init {
        alarmList.value = mutableListOf(
            Alarm(
                0,
                0,
                0,
                0,
                false,
                0,
                0
            )
        )

        alarmPattern.value = AlarmPattern(
            0,
            "",
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            1,
            1,
            false
        )
    }

    fun refleshData(applicationContext: Context, patternId: Int) {
        val database =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "mainDatabase")
                .build()
        val alarmDao = database.alarmDao()
        val alarmPatternDao = database.alarmPatternDao()

        GlobalScope.launch(Dispatchers.IO) {
            alarmList.postValue(alarmDao.getAlarmByPatternId(patternId))
            alarmPattern.postValue(alarmPatternDao.getAlarmPattern(patternId))
        }
    }
}

