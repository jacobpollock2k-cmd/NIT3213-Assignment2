package com.android.example.assignment2.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.android.example.assignment2.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DetailsFragment : Fragment() {
    private val args: DetailsFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val courseName = view.findViewById<TextView>(R.id.detailsCourseNameText)
        val courseCode = view.findViewById<TextView>(R.id.detailsCourseCodeText)
        val courseCredit = view.findViewById<TextView>(R.id.detailsCourseCreditsText)
        val courseInstructor = view.findViewById<TextView>(R.id.detailsCourseInstructorText)
        val courseDescription = view.findViewById<TextView>(R.id.detailsCourseDescriptionText)


        courseName.text = args.details.courseName
        courseCode.text = args.details.courseCode
        courseCredit.text = args.details.credits.toString()
        courseInstructor.text = args.details.instructor
        courseDescription.text = args.details.description


    }


}