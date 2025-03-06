package com.example.courseallocationapp

import android.os.Bundle
import android.widget.*
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity

class SubjectActivity : AppCompatActivity() {
    private lateinit var dbHelper: SubjectDatabaseHelper
    private lateinit var tableLayout: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject)

        val etSubjectCode = findViewById<EditText>(R.id.SubjectCode)
        val etSubjectTitle = findViewById<EditText>(R.id.SubjectTitle)
        val btnSubmit = findViewById<Button>(R.id.btnSubmitSubject)
        tableLayout = findViewById(R.id.tableLayoutSubjects)

        dbHelper = SubjectDatabaseHelper(this)

        // Load existing subjects
        loadSubjects()

        btnSubmit.setOnClickListener {
            val code = etSubjectCode.text.toString().trim()
            val title = etSubjectTitle.text.toString().trim()

            if (code.isNotEmpty() && title.isNotEmpty()) {
                val success = dbHelper.insertSubject(code, title)
                if (success) {
                    Toast.makeText(this, "Subject added!", Toast.LENGTH_SHORT).show()
                    loadSubjects() // Refresh table
                } else {
                    Toast.makeText(this, "Error adding subject!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadSubjects() {
        val subjects = dbHelper.getAllSubjects()

        // Sort subjects by code
        val sortedSubjects = subjects.sortedBy { it.first }

        // Clear previous data in TableLayout
        tableLayout.removeViews(1, tableLayout.childCount - 1) // Keep header row

        // Add sorted subjects to table
        for ((code, title) in sortedSubjects) {
            val row = TableRow(this)

            val tvCode = TextView(this).apply {
                text = code
                setPadding(20, 20, 20, 20)
                gravity = Gravity.CENTER
                layoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)
            }

            val tvTitle = TextView(this).apply {
                text = title
                setPadding(20, 20, 20, 20)
                gravity = Gravity.CENTER
                layoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)
            }

            row.addView(tvCode)
            row.addView(tvTitle)
            tableLayout.addView(row)
        }
    }
}




//package com.example.courseallocationapp
//
//
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//
//class SubjectActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_subject)
//
//        val etSubjectCode = findViewById<EditText>(R.id.etSubjectCode)
//        val etSubjectTitle = findViewById<EditText>(R.id.etSubjectTitle)
//        val btnSubmit = findViewById<Button>(R.id.btnSubmitSubject)
//
//        btnSubmit.setOnClickListener {
//            val code = etSubjectCode.text.toString()
//            val title = etSubjectTitle.text.toString()
//            Toast.makeText(this, "Subject: $code, $title", Toast.LENGTH_SHORT).show()
//        }
//    }
//}
