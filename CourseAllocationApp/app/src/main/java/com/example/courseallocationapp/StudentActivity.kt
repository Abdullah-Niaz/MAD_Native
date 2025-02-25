package com.example.courseallocationapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class StudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        val etStudentID = findViewById<EditText>(R.id.etStudentID)
        val etStudentName = findViewById<EditText>(R.id.etStudentName)
        val btnSubmit = findViewById<Button>(R.id.btnSubmitStudent)

        btnSubmit.setOnClickListener {
            val id = etStudentID.text.toString()
            val name = etStudentName.text.toString()
            Toast.makeText(this, "Student: $id, $name", Toast.LENGTH_SHORT).show()
        }
    }
}
