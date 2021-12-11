package com.example.openapiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.net.URL
import java.nio.charset.Charset


class MainActivity : AppCompatActivity() {
        lateinit var message: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.getforcastbtn)
        button.setOnClickListener {
            doAsync {
                RunRequest()

                uiThread {
                    longToast("")
                }
            }
        }

    }


     fun RunRequest(){
        val cityName = findViewById<EditText>(R.id.cityname)
        //val cityName1 = cityName.getText()
        val city = cityName.text

         
        val str1 = "https://api.openweathermap.org/data/2.5/weather?q="
        //val str2 = "&appid=6bb0e04941e82a1e0d4ed117806f60be"
         val str2 = "&units=metric&cnt=7&appid=6bb0e04941e82a1e0d4ed117806f60be"
        val sb = StringBuilder()
        sb.append(str1).append(city).append(str2)
        val str3 = sb.toString()
        Log.d("URL Report1", str3)
        lifecycleScope.launchWhenCreated {
            withContext(Dispatchers.IO) {
                // network call
                val cityResult = URL(str3).readText(Charset.forName("ISO-8859-1"))
                Log.d("URL Report", cityResult)
                val jsonObj = JSONObject(cityResult)
                val main = jsonObj.getJSONObject("main")
                val temp = main.getString("temp") + "°C"
                message = "Today's weather forcast in " + city + " is " + temp
               Log.d("Message supposed", message)

            }
        }

         Log.d("Message supposedantent",  message)
        val intent = Intent(this, ShowWeatherActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)

    }
}


