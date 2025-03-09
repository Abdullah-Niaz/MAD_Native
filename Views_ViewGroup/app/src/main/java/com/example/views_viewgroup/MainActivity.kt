package com.example.views_viewgroup

import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.views_viewgroup.ui.theme.Views_ViewGroupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val btn = findViewById<Button>(R.id.button)
        val btnreset = findViewById<Button>(R.id.buttonreset)
        val text = findViewById<TextView>(R.id.textView)

        btn.setOnClickListener{
            text.text= "Done With Listen"
        }
        btnreset.setOnClickListener{
            text.text = "Hello! World"
        }
    }
}
