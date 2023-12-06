package com.example.nextgenweatherapp.model

data class Weather(
    val cityName: String,
    val temperature: Double,
    val weatherDescription: String,
    val icon: String,
)
