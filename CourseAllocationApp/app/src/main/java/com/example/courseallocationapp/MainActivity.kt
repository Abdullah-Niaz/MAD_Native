package com.example.courseallocationapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStudent = findViewById<Button>(R.id.btnStudent)
        val btnProfessor = findViewById<Button>(R.id.btnProfessor)
        val btnSubject = findViewById<Button>(R.id.btnSubject)
        val btnCourseAllocation = findViewById<Button>(R.id.btnCourseAllocation)
        val btnTestingActivity = findViewById<Button>(R.id.testingId)

        btnStudent.setOnClickListener {
            startActivity(Intent(this, StudentActivity::class.java))
        }

        btnProfessor.setOnClickListener {
            startActivity(Intent(this, ProfessorActivity::class.java))
        }

        btnSubject.setOnClickListener {
            startActivity(Intent(this, SubjectActivity::class.java))
        }

        btnCourseAllocation.setOnClickListener {
            startActivity(Intent(this, CourseAllocationActivity::class.java))
        }
        btnTestingActivity.setOnClickListener{
           startActivity(Intent(this, TestingActivity::class.java))
        }
    }
}
