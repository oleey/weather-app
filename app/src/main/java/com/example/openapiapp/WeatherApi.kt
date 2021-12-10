package com.example.openapiapp

import android.text.Editable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface  WeatherApi {
        @GET("/weather?")

        fun getTemp(@Query("q") city: Editable,
                    @Query("appid") key: String)
        : Call<WeatherReportResponse>
}

