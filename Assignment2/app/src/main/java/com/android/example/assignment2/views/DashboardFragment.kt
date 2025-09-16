package com.android.example.assignment2.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.android.example.assignment2.R
import com.android.example.assignment2.models.Course
import com.android.example.assignment2.models.KeyPass
import com.android.example.assignment2.recycleview.MyAdapter
import com.android.example.assignment2.viewmodels.ApiViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private val args: DashboardFragmentArgs by navArgs()

    private val viewModel: ApiViewModel by viewModels()
    private lateinit var myAdapter: MyAdapter
    private lateinit var navigationFunctionLambda: (Course) -> Unit
    private val testCourseList: MutableList<Course> = mutableListOf<Course>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val importedKeyPass = args.KeyPass.keypass
        Log.d("DashboardFragment", "KeyPass: ${importedKeyPass}")

        navigationFunctionLambda = {findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToDetailsFragment(details = it))}
        myAdapter=MyAdapter(testCourseList, navigationFunctionLambda)

        viewModel.getCourses(importedKeyPass)

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                //delay(1000)
                viewModel.objectState2.collect { itemsInApiResponse ->
                    myAdapter.updateData(itemsInApiResponse.entities)
                    Log.d("DashboardFragment", "Courses: ${myAdapter.itemCount}")
                    Log.d("DashboardFragment", "Courses: ${itemsInApiResponse.entities}")
                }
            }
        }
        view.findViewById<RecyclerView>(R.id.recyclerView).adapter = myAdapter
    }


}