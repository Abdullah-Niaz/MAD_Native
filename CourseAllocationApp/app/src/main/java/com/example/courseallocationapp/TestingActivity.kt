package com.example.courseallocationapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TestingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing)

        val test = findViewById<Button>(R.id.testingButton)


        test.setOnClickListener{
            Toast.makeText(this, "Student Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}