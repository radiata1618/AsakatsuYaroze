package com.app.asakatsuyaroze.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AlarmDao {
    @Insert
    fun insert(alarm : Alarm)

    @Update
    fun update(alarm : Alarm)

    @Delete
    fun delete(alarm : Alarm)

    @Query("delete from alarm")
    fun deleteAll()

    @Query("select * from alarm")
    fun getAll(): List<Alarm>


    @Query("select * from alarm where id = :p0")
    fun getLiveData(p0: Int): LiveData<Alarm>


    @Query("delete from alarm where patternId = :p0 and alarmType = 1")
    fun deleteAlarmByPatternIdType1(p0: Int): Unit

    @Query("delete from alarm where patternId = :p0 and alarmType = 2")
    fun deleteAlarmByPatternIdType2(p0: Int): Unit


    @Query("select * from alarm where patternId = :p0 and alarmType = 1")
    fun getAlarmByPatternIdType1(p0: Int): List<Alarm>

    @Query("select * from alarm where patternId = :p0 and alarmType = 2")
    fun getAlarmByPatternIdType2(p0: Int): List<Alarm>

    @Query("select * from alarm where patternId = :p0 and alarmType = 3")
    fun getAlarmByPatternIdType3(p0: Int): List<Alarm>

    @Query("select * from alarm where patternId = :p0")
    fun getAlarmByPatternId(p0: Int): List<Alarm>
}