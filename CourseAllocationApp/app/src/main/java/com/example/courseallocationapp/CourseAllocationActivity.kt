package com.example.courseallocationapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CourseAllocationActivity : AppCompatActivity() {
    private lateinit var dbHelper: CourseAllocationDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_allocation)

        dbHelper = CourseAllocationDatabaseHelper(this)

        val etStudentID = findViewById<EditText>(R.id.etStudentIDAlloc)
        val etSubjectCode = findViewById<EditText>(R.id.etSubjectCodeAlloc)
        val etProfessorID = findViewById<EditText>(R.id.etProfessorIDAlloc)
        val btnSubmit = findViewById<Button>(R.id.btnSubmitAllocation)

        btnSubmit.setOnClickListener {
            val studentID = etStudentID.text.toString().trim()
            val subjectCode = etSubjectCode.text.toString().trim()
            val professorID = etProfessorID.text.toString().trim()

            if (studentID.isEmpty() || subjectCode.isEmpty() || professorID.isEmpty()) {
                Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show()
            } else {
                val isInserted = dbHelper.insertAllocation(studentID, subjectCode, professorID)
                if (isInserted) {
                    Toast.makeText(this, "Course allocated successfully!", Toast.LENGTH_SHORT).show()
                    etStudentID.text.clear()
                    etSubjectCode.text.clear()
                    etProfessorID.text.clear()
                } else {
                    Toast.makeText(this, "Error: Failed to allocate course!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}


//package com.example.courseallocationapp
//
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//
//
//class CourseAllocationActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_course_allocation)
//
//        val etStudentID = findViewById<EditText>(R.id.etStudentIDAlloc)
//        val etSubjectCode = findViewById<EditText>(R.id.etSubjectCodeAlloc)
//        val etProfessorID = findViewById<EditText>(R.id.etProfessorIDAlloc)
//        val btnSubmit = findViewById<Button>(R.id.btnSubmitAllocation)
//
////        btnSubmit.setOnClickListener {
////            val studentID = etStudentID.text.toString()
////            val subjectCode = etSubjectCode.text.toString()
////            val professorID = etProfessorID.text.toString()
////            Toast.makeText(this, "Allocated: $studentID - $subjectCode - $professorID", Toast.LENGTH_SHORT).show()
////        }
//    }
//}
