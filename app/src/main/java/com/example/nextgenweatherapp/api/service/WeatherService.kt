/**
 * WeatherService.kt
 * @desc - WeatherService class is used to make API calls to the OpenWeatherMap API
 * @param - None
 * @return - None
 */
package com.example.nextgenweatherapp.api.service.service

import com.example.nextgenweatherapp.BuildConfig
import com.example.nextgenweatherapp.api.response.CityCodeResponse
import com.example.nextgenweatherapp.api.response.WeatherResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("/geo/1.0/direct")
    fun getCityCoordinates(
        @Query("q") cityName: String,
        @Query("limit") limit: Int = 5,
        @Query("appid") apiKey: String = BuildConfig.API_KEY,
    ): Call<CityCodeResponse>

    @GET("/data/2.5/weather")
    fun getCurrentWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("API_KEY") apiKey: String = BuildConfig.API_KEY,
    ): Call<WeatherResponse>
}
