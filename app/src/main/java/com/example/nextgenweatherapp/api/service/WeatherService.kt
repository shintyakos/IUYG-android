/**
 * WeatherService.kt
 * @desc - WeatherService class is used to make API calls to the OpenWeatherMap API
 * @param - None
 * @return - None
 */
package com.example.nextgenweatherapp.api.service.service

import com.example.nextgenweatherapp.BuildConfig
import com.example.nextgenweatherapp.api.response.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("/VisualCrossingWebServices/rest/services/timeline/Tokyo/next7days")
    fun getWeather(
        @Query("unitGroup") unit: String = "metric",
        @Query("key") apiKey: String = BuildConfig.API_KEY,
        @Query("contentType") include: String = "json",
    ): Call<WeatherResponse>
}
