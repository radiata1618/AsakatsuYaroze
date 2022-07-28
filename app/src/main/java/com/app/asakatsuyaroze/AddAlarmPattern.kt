package com.app.asakatsuyaroze

import AlarmPatternSerializable
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.app.asakatsuyaroze.database.AlarmPattern
import com.app.asakatsuyaroze.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

public final class AddAlarmPattern : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_alarm_pattern)


//        val viewModel = viewModels(::AddAlarmPatternViewModel)
//
//        val viewModel: CountViewModel= ViewModelProviders.of(this).get(CountViewModel::class.java)


    }


    fun registerButtonOnClick(view: View) {


        val editText = findViewById<EditText>(R.id.textAlarmPatternName)

//        Toast.makeText(this, "タップされました。", Toast.LENGTH_SHORT).show()
        val database =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "mainDatabase")
                .build()
        val alarmPatternDao = database.alarmPatternDao()
        val newAlarmPattern:AlarmPattern = AlarmPattern(
            0,
            editText.text.toString(),
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            0,
            0,
            false
        )
        GlobalScope.launch(Dispatchers.IO) { // 非同期処理
//            val lastId = notificationDao.selectLastId()
            // 最後のidにプラス1して新しいデータを追加
//            val state = NotificationState(lastId + 1, NotificationType.GOOD, "いいねをもらいました")
            alarmPatternDao.insert(newAlarmPattern)

            GlobalScope.launch(Dispatchers.Main) {  // main thread
                Log.v("TAG", "after insert ${alarmPatternDao.getAll().toString()}")
                Toast.makeText(this@AddAlarmPattern, "データ追加しました", Toast.LENGTH_SHORT).show()
            }
        }
        val intent = Intent(applicationContext, SetAlarmPattern::class.java)

        val alarmPatternSerializable:AlarmPatternSerializable=AlarmPatternSerializable(newAlarmPattern)
        intent.putExtra("alarmPattern",alarmPatternSerializable)
        startActivity(intent)

    }


}

