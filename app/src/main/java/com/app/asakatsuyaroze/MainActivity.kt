package com.app.asakatsuyaroze

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.asakatsuyaroze.adapter.AlarmPatternAdapter
import com.app.asakatsuyaroze.data.AlarmPattern
import com.app.asakatsuyaroze.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AlarmPatternAdapter
    private var alarmPatterns: MutableList<AlarmPattern> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//    val database =
//        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "mainDatabase")
//            .build()
//    val alarmPatternDao = database.alarmPatternDao()
//
//    GlobalScope.launch(Dispatchers.IO) {
//        alarmPatternList=alarmPatternDao.getAlarmPattern(alarmPatternId)
//    }

        alarmPatterns.add(
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
        )

        alarmPatterns.add(
            AlarmPattern(
                1,
                "name2",
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
        )

        alarmPatterns.add(
            AlarmPattern(
                1,
                "name3",
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
        )


        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.recyclerView.layoutManager =  LinearLayoutManager(this)

        val dividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.separator)!!)

        adapter = AlarmPatternAdapter(alarmPatterns)
        binding.recyclerView.adapter = adapter
    }

    fun floatingActionButtonClick(view: View) {
//        Toast.makeText(this, "タップされました。", Toast.LENGTH_SHORT).show()
        val intent = Intent(applicationContext, AddAlarmPattern::class.java)
        startActivity(intent)
    }

}