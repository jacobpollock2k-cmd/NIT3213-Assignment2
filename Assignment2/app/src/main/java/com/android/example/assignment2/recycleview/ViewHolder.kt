package com.android.example.assignment2.recycleview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.example.assignment2.R
import com.android.example.assignment2.models.Course

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val textView = view.findViewById<TextView>(R.id.viewHolderText)

    fun bind(item: Course){
        textView.text = item.toString()
    }
}