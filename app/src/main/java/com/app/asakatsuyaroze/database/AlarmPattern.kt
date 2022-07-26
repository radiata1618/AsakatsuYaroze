package com.app.asakatsuyaroze.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "alarmPattern")
data class AlarmPattern(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val patternName: String,
    val monday: Boolean,
    val tuesday: Boolean,
    val wednesday: Boolean,
    val thursday: Boolean,
    val friday: Boolean,
    val saturday: Boolean,
    val sunday: Boolean,
    val goToBedTimeHour: Int,
    val goToBedTimeMinte: Int,
    val forceGoToBedEnable: Boolean,
)


val getPatternName = AlarmPattern::patternName