package com.example.openapiapp

import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.net.URL

class ShowWeatherActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forcast)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val cityMessage = intent.getStringExtra("City")
        val temp = intent.getStringExtra("Temp")

        // Capture the layout's TextView and set the string as its text
        val todaytemp = findViewById<TextView>(R.id.todaytemp).apply {
            text = temp
        }
        val city = findViewById<TextView>(R.id.city).apply {
            text = cityMessage
        }

        val description = findViewById<TextView>(R.id.desc).apply {
            text = message
        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy(){
        super.onDestroy()
    }
}