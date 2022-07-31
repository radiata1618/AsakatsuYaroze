package com.app.asakatsuyaroze.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.asakatsuyaroze.R
import com.app.asakatsuyaroze.data.AlarmPattern
import com.app.asakatsuyaroze.databinding.AlarmpatternRowBinding

class AlarmPatternViewHolder(var binding: AlarmpatternRowBinding) : RecyclerView.ViewHolder(binding.root)

class AlarmPatternAdapter(private val items: List<AlarmPattern>) : RecyclerView.Adapter<AlarmPatternViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmPatternViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: AlarmpatternRowBinding = DataBindingUtil.inflate(inflater, R.layout.alarmpattern_row, parent, false)
        return AlarmPatternViewHolder(binding) //crate view holder
    }

    override fun onBindViewHolder(holder: AlarmPatternViewHolder, position: Int) {
        holder.binding.alarmPattern = items[position] //apply data
    }

    override fun getItemCount(): Int {
        return items.count()
    }
}