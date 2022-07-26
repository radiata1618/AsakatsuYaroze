package com.app.asakatsuyaroze.database

import androidx.room.*

@Dao
interface AlarmPatternDao {
    @Insert
    fun insert(alarmPattern : AlarmPattern)

    @Update
    fun update(alarmPattern : AlarmPattern)

    @Delete
    fun delete(alarmPattern : AlarmPattern)

    @Query("delete from alarmPattern")
    fun deleteAll()

    @Query("select * from alarmPattern")
    fun getAll(): List<AlarmPattern>

    @Query("select * from alarmPattern where id = :id")
    fun getAlarmPattern(id: Int): AlarmPattern
}