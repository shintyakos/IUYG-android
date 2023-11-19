package com.example.nextgenweatherapp.api.response

data class CityCodeResponse(
    val name: String,
    val lat: Double,
    val lon: Double,
    val country: String,
    val state: String,
)
