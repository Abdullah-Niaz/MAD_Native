package com.example.activitylifecycle

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.os.Handler
import android.os.Looper
import android.widget.Toast

import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    private lateinit var lifecycleStatus: TextView
    private fun updateText(message: String) {
        lifecycleStatus.text = message
    }
    private val handler = Handler(Looper.getMainLooper())  // Runs on UI thread

    private var counter = 0

    private val updateTask = object : Runnable {
        override fun run() {
            counter++
            lifecycleStatus.text = "Live Data Update: $counter"
            Log.d("Lifecycle", "Live Data Updated: $counter")

            handler.postDelayed(this, 1000)  // Updates every 1 second
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toast = Toast.makeText(applicationContext, "oncreate Method called", Toast.LENGTH_LONG)
        toast.show()
        setContentView(R.layout.activity_main)
        lifecycleStatus = findViewById(R.id.lifecycleStatus)

        updateText("onCreate() called");

        Log.d("LifeCycle", "onCreate called");
    }

    override  fun onStart(){
        super.onStart()
        val toast = Toast.makeText(applicationContext, "onStart Method Called", Toast.LENGTH_LONG)
        toast.show()
        updateText("onStart() called");
        Log.d("LifeCycle","onStart called")

    }



    override fun onResume() {
        super.onResume()

        val toast = Toast.makeText(applicationContext,"onResume Method Called", Toast.LENGTH_LONG)
        toast.show()
        updateText("onResume() called");

        handler.post(updateTask)  // Start updating when resumed

        Log.d("LifeCycle","onResume called")
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(updateTask)  // Stop updating when paused
        Log.d("Lifecycle", "onPause: Live Data Stopped")
    }

    override fun onRestart() {
        super.onRestart()
        val toast = Toast.makeText(applicationContext, "onRestart Method Called", Toast.LENGTH_LONG)
        toast.show()
        updateText("onRestart() called");
        handler.post(updateTask)
        Log.d("LifeCycle","onRestart called")
    }
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(updateTask)  // Clean up resources
        Log.d("Lifecycle", "onDestroy: Activity Destroyed, Cleaning Up Resources")
    }
}

