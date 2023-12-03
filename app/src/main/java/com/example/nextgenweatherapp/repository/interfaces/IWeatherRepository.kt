package com.example.nextgenweatherapp.repository.interfaces

interface IWeatherRepository {
    // 現在の天気データの取得ロジックを実装する
    suspend fun getCurrentWeather()

    // 毎時の天気データの取得ロジックを実装する
    suspend fun getHourlyWeather()

    // 週間の天気データの取得ロジックを実装する
    suspend fun getWeeklyWeather()
}
