package com.example.courseallocationapp

import android.os.Bundle
import android.widget.*
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity

class StudentActivity : AppCompatActivity() {
    private lateinit var dbHelper:StudentDatabaseHelper
    private lateinit var tableLayout: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        val etStudentID = findViewById<EditText>(R.id.StudentID)
        val etStudentName = findViewById<EditText>(R.id.StudentName)
        val btnSubmit = findViewById<Button>(R.id.btnSubmitStudent)
        tableLayout = findViewById(R.id.tableLayoutStudents)

        dbHelper = StudentDatabaseHelper(this)

        // Load existing students
        loadStudents()

        btnSubmit.setOnClickListener {
            val id = etStudentID.text.toString().trim()
            val name = etStudentName.text.toString().trim()

            if (id.isNotEmpty() && name.isNotEmpty()) {
                val success = dbHelper.insertStudent(id, name)
                if (success) {
                    Toast.makeText(this, "Student added!", Toast.LENGTH_SHORT).show()
                    loadStudents() // Refresh table
                } else {
                    Toast.makeText(this, "Error adding student!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadStudents() {
        val students = dbHelper.getAllStudents()

        // Sort students by ID
        val sortedStudents = students.sortedBy { it.first.toIntOrNull() ?: Int.MAX_VALUE }

        // Clear previous data in TableLayout
        val tableLayout = findViewById<TableLayout>(R.id.tableLayoutStudents)
        tableLayout.removeViews(1, tableLayout.childCount - 1) // Keep header row

        // Add sorted students to table
        for ((id, name) in sortedStudents) {
            val row = TableRow(this)

            val tvId = TextView(this).apply {
                text = id
                setPadding(20, 20, 20, 20)
                gravity = Gravity.CENTER // Center text
                layoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)
            }

            val tvName = TextView(this).apply {
                text = name
                setPadding(20, 20, 20, 20)
                gravity = Gravity.CENTER // Center text
                layoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)
            }

            row.addView(tvId)
            row.addView(tvName)
            tableLayout.addView(row)
        }
    }


}




//package com.example.courseallocationapp
//
//import android.os.Bundle
//import android.widget.*
//import androidx.appcompat.app.AppCompatActivity
//
//class StudentActivity : AppCompatActivity() {
//    private lateinit var dbHelper: StudentDatabaseHelper
//    private lateinit var listView: ListView
//    private lateinit var adapter: ArrayAdapter<String>
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_student)
//
//        val etStudentID = findViewById<EditText>(R.id.etStudentID)
//        val etStudentName = findViewById<EditText>(R.id.etStudentName)
//        val btnSubmit = findViewById<Button>(R.id.btnSubmitStudent)
//        listView = findViewById(R.id.listViewStudents)
//
//        dbHelper = StudentDatabaseHelper(this)
//        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mutableListOf())
//        listView.adapter = adapter
//
//        // Load existing students
//        loadStudents()
//
//        btnSubmit.setOnClickListener {
//            val id = etStudentID.text.toString().trim()
//            val name = etStudentName.text.toString().trim()
//
//            if (id.isNotEmpty() && name.isNotEmpty()) {
//                val success = dbHelper.insertStudent(id, name)
//                if (success) {
//                    Toast.makeText(this, "Student added!", Toast.LENGTH_SHORT).show()
//                    loadStudents() // Refresh ListView
//                } else {
//                    Toast.makeText(this, "Error adding student!", Toast.LENGTH_SHORT).show()
//                }
//            } else {
//                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//
//    private fun loadStudents() {
//        val students = dbHelper.getAllStudents()
//        val studentStrings = students.map { "${it.first}: ${it.second}" }
//        adapter.clear()
//        adapter.addAll(studentStrings)
//        adapter.notifyDataSetChanged()
//    }
//}

//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//
//class StudentActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_student)
//
//        val etStudentID = findViewById<EditText>(R.id.etStudentID)
//        val etStudentName = findViewById<EditText>(R.id.etStudentName)
//        val btnSubmit = findViewById<Button>(R.id.btnSubmitStudent)
//
//        btnSubmit.setOnClickListener {
//            val id = etStudentID.text.toString()
//            val name = etStudentName.text.toString()
//            Toast.makeText(this, "Student: $id, $name", Toast.LENGTH_SHORT).show()
//        }
//    }
//}
