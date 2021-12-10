package com.example.openapiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.widget.Button
import android.widget.EditText
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.URL


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var temp = " "
        val cityName = findViewById<EditText>(R.id.cityname)
        val cityName1 = cityName.getText()
        var message =" "

        val button = findViewById<Button>(R.id.getforcastbtn)
        button.setOnClickListener {
            doAsync {
                val url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName1 + "&appid=6bb0e04941e82a1e0d4ed117806f60be/"
                val resultJson = URL(url).readText()
                Log.d("Weather Report",resultJson)
                val jsonObj = JSONObject(resultJson)
                val main = jsonObj.getJSONObject("main")
                temp = main.getString("pressure")+"°C"

                uiThread { toast("Request Performed") }
            }

            message = "Today's weather forcast in " + cityName1 + " is " + temp
            val intent = Intent(this, ShowWeatherActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, message)
            }
            startActivity(intent)
        }

        //var temp = ""


        //val url = "https://api.openweathermap.org/data/2.5/"
        //val key = "6bb0e04941e82a1e0d4ed117806f60be"
        //weather?q=" + cityName1 + ",in&units=metric&appid=6bb0e04941e82a1e0d4ed117806f60be/"




        //val resultJson = URL(url).readText()
       // Log.d("Weather Report",resultJson)
        //val jsonObj = JSONObject(resultJson)
        //val main = jsonObj.getJSONObject("main")
        //val temp = "Today's weather forcast in " + cityName1 + " is " + main.getString("temp")+"°C"

        //val button = findViewById<Button>(R.id.getforcastbtn)
        //button.setOnClickListener {

            /* Creates an instance of the UserService using a simple Retrofit builder using Moshi
 * as a JSON converter, this will append the endpoints set on the UserService interface
 * (for example '/api', '/api?results=2') with the base URL set here, resulting on the
 * full URL that will be called: 'https://randomuser.me/api' */
          //  val service = Retrofit.Builder()
            //    .baseUrl(url)
              //  .addConverterFactory(MoshiConverterFactory.create())
              //  .build()
              //  .create(WeatherApi::class.java)

            /* Calls the endpoint set on getUsers (/api) from UserService using enqueue method
         * that creates a new worker thread to make the HTTP call */
           // service.getTemp(cityName1, key).enqueue(object : Callback<WeatherReportResponse> {

                /* The HTTP call failed. This method is run on the main thread */
               // override fun onFailure(call: Call<WeatherReportResponse>, t: Throwable) {
               //     Log.d("TAG_", "An error happened!")
                //    t.printStackTrace()
               // }

                //override fun onResponse(call: Call<WeatherReportResponse>, response: Response<WeatherReportResponse>) {
                    /* This will print the response of the network call to the Logcat */
                //    Log.d("TAGonResponse_", cityName1.toString())
                //    temp = "Today's weather forcast in " + cityName1 + " is " + response.body() +" °C " + response.body().toString()
              //  }
          //  })
            // Code here executes on main thread after user presses button
            //Log.d("Get Forcast btn clicked", "I have been clicked " + cityName1)
           // val intent = Intent(this, ShowWeatherActivity::class.java).apply {
           //     putExtra(EXTRA_MESSAGE, temp)
           // }
          //  startActivity(intent)
       // }
    }
}
