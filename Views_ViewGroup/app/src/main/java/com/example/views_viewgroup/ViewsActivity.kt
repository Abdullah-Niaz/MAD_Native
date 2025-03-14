package com.example.views_viewgroup


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent
import android.widget.Toast


class ViewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views)


        val btnTextView = findViewById<Button>(R.id.btnTextView)
        val btnButton = findViewById<Button>(R.id.btnButton)
        val btnImageView = findViewById<Button>(R.id.btnImageView)
        val btnEditText = findViewById<Button>(R.id.btnEditText)


        btnTextView.setOnClickListener {
            val toast = Toast.makeText(this, "TextView Clicked",Toast.LENGTH_LONG)
            toast.show()
        }

        btnButton.setOnClickListener {
            val toast = Toast.makeText(this, "Button Clicked",Toast.LENGTH_LONG)
            toast.show()
        }

        btnImageView.setOnClickListener {
            val toast = Toast.makeText(this, "ImageView Clicked",Toast.LENGTH_LONG)
            toast.show()        }

        btnEditText.setOnClickListener {
            val toast = Toast.makeText(this, "EditText Clicked",Toast.LENGTH_LONG)
            toast.show()        }
    }
}