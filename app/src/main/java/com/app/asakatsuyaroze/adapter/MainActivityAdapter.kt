package com.app.asakatsuyaroze.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.asakatsuyaroze.R
import com.app.asakatsuyaroze.data.AlarmPattern
import com.app.asakatsuyaroze.databinding.AlarmpatternRowBinding

class MainActivityViewHolder(var binding: AlarmpatternRowBinding) : RecyclerView.ViewHolder(binding.root)

class MainActivityAdapter(private val items: List<AlarmPattern>) : RecyclerView.Adapter<MainActivityViewHolder>() {


    private var alarmPatternList = emptyList<AlarmPattern>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: AlarmpatternRowBinding = DataBindingUtil.inflate(inflater, R.layout.alarmpattern_row, parent, false)
        return MainActivityViewHolder(binding) //crate view holder
    }

    override fun onBindViewHolder(holder: MainActivityViewHolder, position: Int) {
        holder.binding.alarmPattern = items[position] //apply data
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    fun setData(alarmPattern: List<AlarmPattern>) {
        this.alarmPatternList = alarmPattern
        notifyDataSetChanged()
    }
    fun getData(position: Int): AlarmPattern {
        return this.alarmPatternList[position]
    }
}