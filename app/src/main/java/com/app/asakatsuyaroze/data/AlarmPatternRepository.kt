package com.app.asakatsuyaroze.data
import androidx.lifecycle.LiveData

class AlarmPatternRepository(private val alarmPatternDao: AlarmPatternDao) {

    val readAllData: LiveData<List<AlarmPattern>> = alarmPatternDao.getAllLiveData()

    suspend fun insertAlarmPattern(alarmPattern: AlarmPattern) {
        alarmPatternDao.insert(alarmPattern)
    }

    suspend fun deleteAlarmPattern(alarmPattern: AlarmPattern) {
        alarmPatternDao.delete(alarmPattern)
    }

    suspend fun deleteAllAlarmPatterns() {
        alarmPatternDao.deleteAll()
    }
}