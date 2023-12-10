package com.example.nextgenweatherapp.repository.interfaces

import com.example.nextgenweatherapp.database.data.WeatherModel

interface IWeatherRepository {
    // 現在の天気データの取得ロジックを実装する
    suspend fun getCurrentWeather(): WeatherModel?
}
