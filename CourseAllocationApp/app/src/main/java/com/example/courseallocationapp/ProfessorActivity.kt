package com.example.courseallocationapp

import android.os.Bundle
import android.widget.*
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity

class ProfessorActivity : AppCompatActivity() {
    private lateinit var dbHelper: ProfessorDatabaseHelper
    private lateinit var tableLayout: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_professor)

        val etProfessorID = findViewById<EditText>(R.id.etProfessorID)
        val etProfessorName = findViewById<EditText>(R.id.etProfessorName)
        val btnSubmit = findViewById<Button>(R.id.btnSubmitProfessor)
        tableLayout = findViewById(R.id.tableLayoutProfessors)

        dbHelper = ProfessorDatabaseHelper(this)

        // Load existing professors
        loadProfessors()

        btnSubmit.setOnClickListener {
            val id = etProfessorID.text.toString().trim()
            val name = etProfessorName.text.toString().trim()

            if (id.isNotEmpty() && name.isNotEmpty()) {
                val success = dbHelper.insertProfessor(id, name)
                if (success) {
                    Toast.makeText(this, "Professor added!", Toast.LENGTH_SHORT).show()
                    loadProfessors() // Refresh table
                } else {
                    Toast.makeText(this, "Error adding professor!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadProfessors() {
        val professors = dbHelper.getAllProfessors()

        // Sort professors by ID
        val sortedProfessors = professors.sortedBy { it.first.toIntOrNull() ?: Int.MAX_VALUE }

        // Clear previous data in TableLayout
        tableLayout.removeViews(1, tableLayout.childCount - 1) // Keep header row

        // Add sorted professors to table
        for ((id, name) in sortedProfessors) {
            val row = TableRow(this)

            val tvId = TextView(this).apply {
                text = id
                setPadding(20, 20, 20, 20)
                gravity = Gravity.CENTER
                layoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)
            }

            val tvName = TextView(this).apply {
                text = name
                setPadding(20, 20, 20, 20)
                gravity = Gravity.CENTER
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
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//
//class ProfessorActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_professor)
//
//        val etProfessorID = findViewById<EditText>(R.id.etProfessorID)
//        val etProfessorName = findViewById<EditText>(R.id.etProfessorName)
//        val btnSubmit = findViewById<Button>(R.id.btnSubmitProfessor)
//
//        btnSubmit.setOnClickListener {
//            val id = etProfessorID.text.toString()
//            val name = etProfessorName.text.toString()
//            Toast.makeText(this, "Professor: $id, $name", Toast.LENGTH_SHORT).show()
//        }
//    }
//}
