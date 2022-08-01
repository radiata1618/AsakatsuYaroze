package com.app.asakatsuyaroze.data

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AlarmPatternViewModel(application: Application) : AndroidViewModel(application) {

    var alarmPatternList = MutableLiveData<List<AlarmPattern>>()

    init{

        alarmPatternList.value= mutableListOf((
                AlarmPattern(
                    0,
                    "name1",
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
                ))
    }

    fun refleshData(applicationContext: Context) {
        val database =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "mainDatabase")
                .build()
        val alarmPatternDao = database.alarmPatternDao()

//        GlobalScope.launch(Dispatchers.IO) {
            alarmPatternList.postValue(alarmPatternDao.getAll())
//        }
    }

}
