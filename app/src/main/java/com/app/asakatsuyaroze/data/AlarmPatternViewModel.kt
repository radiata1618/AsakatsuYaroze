package com.app.asakatsuyaroze.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlarmPatternViewModel  (application: Application): AndroidViewModel(application){

//    var alarmPattern: AlarmPattern? = null

    val readAllData: LiveData<List<AlarmPattern>>
    private val repository: AlarmPatternRepository

    init {
        val database =
            Room.databaseBuilder(application, AppDatabase::class.java, "mainDatabase")
                .build()
        val alarmPatternDao = database.alarmPatternDao()
        repository = AlarmPatternRepository(alarmPatternDao)
        readAllData = repository.readAllData
    }

    fun insertAlarmPattern(alarmPattern: AlarmPattern) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAlarmPattern(alarmPattern)
        }
    }

    fun deleteAllWords() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllAlarmPatterns()
        }
    }
}
