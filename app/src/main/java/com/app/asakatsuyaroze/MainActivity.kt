package com.app.asakatsuyaroze

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

//    val floatingActionButton = findViewById<FloatingActionButton>(R.id.floating_action_button)
//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    // xmlにて実装したListViewの取得
    val listView = findViewById<ListView>(R.id.main_list_view)

    // 配列の生成
    val array = arrayOf("リスト１", "リスト２", "リスト３", "リスト４", "リスト５")

    // ArrayAdapterの生成
    val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array)

    // ListViewに、生成したAdapterを設定
    listView.adapter = adapter

    }
    fun floatingActionButtonClick(view: View) {
//        Toast.makeText(this, "タップされました。", Toast.LENGTH_SHORT).show()
        val intent = Intent(applicationContext, AddAlarmPattern::class.java)
        startActivity(intent)
    }

}