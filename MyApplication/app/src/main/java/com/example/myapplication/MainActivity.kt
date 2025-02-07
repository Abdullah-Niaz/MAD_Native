package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to UI elements
        val firstInput = findViewById<EditText>(R.id.firstInput)
        val secondInput = findViewById<EditText>(R.id.secondInput)
        val addButton = findViewById<Button>(R.id.addButton)
        val outputResult = findViewById<EditText>(R.id.outputResult)

        // Set up button click listener
        addButton.setOnClickListener {
            val num1 = firstInput.text.toString().toDoubleOrNull() ?: 0.0
            val num2 = secondInput.text.toString().toDoubleOrNull() ?: 0.0
            val sum = num1 + num2
            outputResult.setText(sum.toString())
        }
    }
}
