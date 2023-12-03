/**
 * HomeViewModel.kt
 * 天気情報に関するビジネスロジックを記述する
 */
package com.example.nextgenweatherapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nextgenweatherapp.model.Weather
import com.example.nextgenweatherapp.repository.WeatherRepository
import com.example.nextgenweatherapp.repository.interfaces.IWeatherRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val weatherData = MutableLiveData<Weather>()
    private lateinit var weatherRepository: IWeatherRepository
    val weatherLiveData: LiveData<Weather> = weatherData

    init {
        weatherRepository = WeatherRepository()
    }
    fun loadWeather() {
        viewModelScope.launch {
            weatherRepository.getCurrentWeather()
        }
    }
}
