package com.example.nextgenweatherapp.repository

import com.example.nextgenweatherapp.database.data.WeatherModel
import com.example.nextgenweatherapp.repository.interfaces.IWeatherRepository

class PreviewWeatherRepository : IWeatherRepository {
    override suspend fun getCurrentWeather(): WeatherModel {
        return WeatherModel().apply {
            cityName = "Tokyo, Japan"
            temperature = 20.0
            weatherDescription = "Cloudy"
            icon = "clear_day"
        }
    }
}
