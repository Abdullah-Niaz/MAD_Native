package com.example.intents

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message = intent.getStringExtra("message")
        val textView = findViewById<TextView>(R.id.textViewMessage)
        textView.text = message ?: "No message received"
    }
}
