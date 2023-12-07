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
    private val weatherRepository: IWeatherRepository = WeatherRepository()
    private val _weatherData = MutableLiveData<Weather>()
    val weatherData: LiveData<Weather> = _weatherData

    /**
     * 天気情報を取得する
     */
    fun loadWeather() {
        viewModelScope.launch {
            try {
                weatherRepository.getCurrentWeather()?.let {
                    val weather = Weather(
                        cityName = it.name,
                        temperature = it.main.temp,
                        weatherDescription = it.weather.description,
                        icon = it.weather.icon,
                    )
                    _weatherData.postValue(weather)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun PreviewLoadWeather() {
        val weather = Weather(
            cityName = "Tokyo",
            temperature = 20.0,
            weatherDescription = "Cloudy",
            icon = "10d",
        )
        _weatherData.postValue(weather)
    }
}
