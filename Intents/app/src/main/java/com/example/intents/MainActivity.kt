package com.example.intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Explicit Intent - Navigate to SecondActivity
        val btnExplicit = findViewById<Button>(R.id.btnExplicit)
        btnExplicit.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("message", "Hello from MainActivity!")
            startActivity(intent)
        }

        // Implicit Intent - Open Website in Browser
        val btnWeb = findViewById<Button>(R.id.btnWeb)
        btnWeb.setOnClickListener {
            val url = "https://www.google.com"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        // Implicit Intent - Open Phone Dialer
        val btnDialer = findViewById<Button>(R.id.btnDialer)
        btnDialer.setOnClickListener {
            val phone = "tel:+1234567890"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse(phone))
            startActivity(intent)
        }

        // Implicit Intent - Open Google Maps
        val btnMaps = findViewById<Button>(R.id.btnMaps)
        btnMaps.setOnClickListener {
            val location = "geo:37.7749,-122.4194"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(location))
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }

        // Implicit Intent - Send Email
        val btnEmail = findViewById<Button>(R.id.btnEmail)
        btnEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:example@email.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hello!")
            intent.putExtra(Intent.EXTRA_TEXT, "This is a test email.")
            startActivity(intent)
        }
    }
}
