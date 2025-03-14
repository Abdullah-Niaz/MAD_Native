package com.example.views_viewgroup

import android.os.Bundle
import android.content.Intent
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


        val btnViews = findViewById<Button>(R.id.btnViews)
        val btnViewGroups = findViewById<Button>(R.id.btnViewGroups)

        btnViews.setOnClickListener {
            val intent = Intent(this, ViewsActivity::class.java)
            startActivity(intent)
        }

        btnViewGroups.setOnClickListener {
            val intent = Intent(this, ViewGroupsActivity::class.java)
            startActivity(intent)
        }
    }
}
