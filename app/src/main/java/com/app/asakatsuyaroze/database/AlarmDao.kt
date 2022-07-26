package com.app.asakatsuyaroze.database

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

    @Query("select * from alarm where id = :id")
    fun getAlarm(id: Int): Alarm

    @Query("select * from alarm where id = :patternId")
    fun getAlarmByPatternId(patternId: Int): Alarm
}