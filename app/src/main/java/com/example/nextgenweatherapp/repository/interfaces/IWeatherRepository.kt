package com.example.nextgenweatherapp.repository.interfaces

import com.example.nextgenweatherapp.api.response.WeatherResponse

interface IWeatherRepository {
    // 現在の天気データの取得ロジックを実装する
    suspend fun getCurrentWeather(): WeatherResponse?

    // 毎時の天気データの取得ロジックを実装する
    suspend fun getHourlyWeather()

    // 週間の天気データの取得ロジックを実装する
    suspend fun getWeeklyWeather()
}
