package com.example.courseallocationapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfessorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_professor)

        val etProfessorID = findViewById<EditText>(R.id.etProfessorID)
        val etProfessorName = findViewById<EditText>(R.id.etProfessorName)
        val btnSubmit = findViewById<Button>(R.id.btnSubmitProfessor)

        btnSubmit.setOnClickListener {
            val id = etProfessorID.text.toString()
            val name = etProfessorName.text.toString()
            Toast.makeText(this, "Professor: $id, $name", Toast.LENGTH_SHORT).show()
        }
    }
}
