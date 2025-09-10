package com.android.example.assignment2.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.example.assignment2.R
import com.android.example.assignment2.models.Course

class MyAdapter(private var dataList: MutableList<Course> = mutableListOf()): RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount()= dataList.size

    fun updateData(newDataList: List<Course>){
        dataList.clear()
        dataList.addAll(newDataList)
        notifyDataSetChanged()
    }
}