package com.example.nextgenweatherapp.repository

import com.example.nextgenweatherapp.repository.interfaces.IWeatherRepository

class RepositoryFactory {
    companion object {
        fun getWeatherRepository(): IWeatherRepository {
            return WeatherRepository()
        }
    }
}
