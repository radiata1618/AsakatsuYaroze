package com.app.asakatsuyaroze

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.asakatsuyaroze.adapter.MainActivityAdapter
import com.app.asakatsuyaroze.data.MainActivityViewModel
import com.app.asakatsuyaroze.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mAlarmPatternViewModel =
            ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val dividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.separator)!!)

        mAlarmPatternViewModel.refleshData(applicationContext)

        mAlarmPatternViewModel.alarmPatternList.observe(this) {
            if(mAlarmPatternViewModel.alarmPatternList.value!=null){
                adapter = MainActivityAdapter(mAlarmPatternViewModel.alarmPatternList.value!!)
                binding.recyclerView.adapter = adapter
            }
        }
    }

    fun floatingActionButtonClick(view: View) {
        val intent = Intent(applicationContext, AddAlarmPattern::class.java)
        startActivity(intent)
    }

}