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
    private val weatherRepository: IWeatherRepository = WeatherRepository()
    val weatherLiveData: LiveData<Weather> = weatherData

    fun loadWeather() {
        viewModelScope.launch {
            try {
                weatherRepository.getCurrentWeather()?.let {
                    val weather = Weather(
                        cityName = it.name ?: "",
                        temperature = it.main?.temp ?: 0.0,
                        weatherDescription = it.weather?.description ?: "",
                        icon = it.weather.icon ?: "",
                    )
                    weatherData.postValue(weather)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
