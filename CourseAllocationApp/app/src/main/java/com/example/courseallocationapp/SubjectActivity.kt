package com.example.courseallocationapp


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SubjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject)

        val etSubjectCode = findViewById<EditText>(R.id.etSubjectCode)
        val etSubjectTitle = findViewById<EditText>(R.id.etSubjectTitle)
        val btnSubmit = findViewById<Button>(R.id.btnSubmitSubject)

        btnSubmit.setOnClickListener {
            val code = etSubjectCode.text.toString()
            val title = etSubjectTitle.text.toString()
            Toast.makeText(this, "Subject: $code, $title", Toast.LENGTH_SHORT).show()
        }
    }
}
