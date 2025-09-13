package com.android.example.assignment2.recycleview

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.example.assignment2.R
import com.android.example.assignment2.models.Course

class ViewHolder(view: View, private val navigationFunction: (Course) -> Unit ) : RecyclerView.ViewHolder(view){
    private val courseName = view.findViewById<TextView>(R.id.coureNameText)
    private val courseCode = view.findViewById<TextView>(R.id.courseCodeText)
    private val courseCredits = view.findViewById<TextView>(R.id.courseCreditsText)
    private val courseInstructor = view.findViewById<TextView>(R.id.courseInstructorText)
    private val button: Button = view.findViewById(R.id.viewHolderButton)



    fun bind(item: Course){
        courseName.text = "Course Name:\n${item.courseName}"
        courseCode.text = "Course Code:\n${item.courseCode}"
        courseCredits.text = "Course Credits:\n${item.credits.toString()}"
        courseInstructor.text = "Course Instructor:\n${item.instructor}"
        button.setOnClickListener {
            navigationFunction(item)
        }
    }
}