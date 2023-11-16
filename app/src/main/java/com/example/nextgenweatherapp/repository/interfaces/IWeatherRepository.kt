package com.example.nextgenweatherapp.repository.interfaces

import androidx.lifecycle.LiveData
import com.example.nextgenweatherapp.model.Weather

interface IWeatherRepository {
    // 現在の天気データの取得ロジックを実装する
    fun getCurrentWeather(): LiveData<Weather>

    // 毎時の天気データの取得ロジックを実装する
    fun getHourlyWeather(): LiveData<Weather>

    // 週間の天気データの取得ロジックを実装する
    fun getWeeklyWeather(): LiveData<Weather>
}
