package com.example.views_viewgroup

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ViewGroupsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewgroups)


        val leftButton = findViewById<Button>(R.id.leftButton)
        val rightButton = findViewById<Button>(R.id.rightButton)
        leftButton.setOnClickListener {
            val toast = Toast.makeText(this, "Left Button Clicked", Toast.LENGTH_LONG)
            toast.show()
        }
        rightButton.setOnClickListener {
            val toast = Toast.makeText(this, "Right Button Clicked",Toast.LENGTH_LONG)
            toast.show()
        }
    }
}
