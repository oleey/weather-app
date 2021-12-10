package com.example.openapiapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RestApi {
    private val weatherApi: WeatherApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.reddit.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        weatherApi = retrofit.create(WeatherApi::class.java)
    }

    //fun getNews(after: String, limit: String): Call<RedditNewsResponse>{
        //return redditApi.getTop(after, limit)
  //  }

    //fun getWeather(main: String): Call<WeatherReportResponse> {
        //return weatherApi.getTop(main)
    //}
}