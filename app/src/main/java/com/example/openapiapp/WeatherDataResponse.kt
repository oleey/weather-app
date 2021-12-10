package com.example.openapiapp

class WeatherDataResponse (
    val main: List<WeatherMainResponse>,
    val city: String?,
    val appid: String?
)