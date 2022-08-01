package com.app.asakatsuyaroze

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.asakatsuyaroze.adapter.AlarmPatternAdapter
import com.app.asakatsuyaroze.data.AlarmPattern
import com.app.asakatsuyaroze.data.AlarmPatternViewModel
import com.app.asakatsuyaroze.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AlarmPatternAdapter
//
//    private lateinit var mAlarmPatternViewModel: AlarmPatternViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mAlarmPatternViewModel = ViewModelProvider(this).get(AlarmPatternViewModel::class.java)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.recyclerView.layoutManager =  LinearLayoutManager(this)

        val dividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.separator)!!)

        GlobalScope.launch(Dispatchers.IO) {
            mAlarmPatternViewModel.refleshData(applicationContext)
            adapter = AlarmPatternAdapter(mAlarmPatternViewModel.alarmPatternList.value!!)
            binding.recyclerView.adapter = adapter

        }

//        mAlarmPatternViewModel.alarmPatternList.observe(this,
//            Observer { resource -> findViewById<TextView>(R.id.textView).text = resource }
//        )
//        adapter = AlarmPatternAdapter(mAlarmPatternViewModel.alarmPatternList.value!!)
//        binding.recyclerView.adapter = adapter
    }

    fun floatingActionButtonClick(view: View) {
//        Toast.makeText(this, "タップされました。", Toast.LENGTH_SHORT).show()
        val intent = Intent(applicationContext, AddAlarmPattern::class.java)
        startActivity(intent)
    }

}