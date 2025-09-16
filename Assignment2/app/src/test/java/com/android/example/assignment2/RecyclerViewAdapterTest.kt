package com.android.example.assignment2

import com.android.example.assignment2.models.Course
import com.android.example.assignment2.models.CourseList
import com.android.example.assignment2.recycleview.MyAdapter
import io.mockk.every
import io.mockk.spyk
import io.mockk.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before


class RecyclerViewAdapterTest {

    private lateinit var myAdapter: MyAdapter
    private val mockNavigationFunction: (Course) -> Unit = {}
    private val exampleCourse = Course("TestCode", "TestName", 1, "TestDescription", "TestInstructor")
    private val exampleCourse2 = Course("TestCode2", "TestName2", 2, "TestDescription2", "TestInstructor2")
    private val exampleCourseList: MutableList<Course> = mutableListOf(exampleCourse,exampleCourse2)
    private val exampleCourseList2 = CourseList(entities = exampleCourseList, 2)

    @Before
    fun setUp() {
        val testCourseList: MutableList<Course> = mutableListOf<Course>()

        myAdapter = spyk(MyAdapter(testCourseList, mockNavigationFunction))
        //myAdapter.updateData(exampleCourseList2.entities)
        every { myAdapter.notifyDataSetChanged()} returns Unit
    }

    @Test
    fun `getItemCount returns correct count`() {

        myAdapter.updateData(exampleCourseList2.entities)
        val itemCount = myAdapter.getItemCount()
        assertEquals(2, itemCount)
    }

    @Test
    fun `updateDate updates dataList and calls notifyDataSetChanged`(){
        val exampleCourse3 = Course("TestCode3", "TestName3", 3, "TestDescription3", "TestInstructor3")
        val newDataList = listOf(exampleCourse, exampleCourse2, exampleCourse3)
        myAdapter.updateData(newDataList)
        val itemCount = myAdapter.getItemCount()

        assertEquals(3, itemCount)
        verify { myAdapter.notifyDataSetChanged() }
    }

    @Test
    fun `onBindViewHolder binding correct position`(){
        val bindedValue = exampleCourseList2.entities.get(0)
        myAdapter.updateData(exampleCourseList2.entities)
        assertEquals(bindedValue, myAdapter.dataList.get(0))
    }

}
