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
import com.example.nextgenweatherapp.repository.RepositoryFactory
import com.example.nextgenweatherapp.repository.interfaces.IWeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val weatherRepository: IWeatherRepository = RepositoryFactory.getWeatherRepository()
    private val _weatherData = MutableLiveData<Weather>()
    val weatherData: LiveData<Weather> = _weatherData

    init {
        loadWeather()
    }

    /**
     * 天気情報を取得する
     */
    fun loadWeather() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                weatherRepository.getCurrentWeather()?.let {
                    val weather = Weather(
                        cityName = "${it.cityName}, Japan",
                        temperature = "${it.temperature}℃",
                        weatherDescription = it.weatherDescription,
                        icon = "https://openweathermap.org/img/wn/${it.icon}.png",
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
            cityName = "Tokyo, Japan",
            temperature = "20.0℃",
            weatherDescription = "Cloudy",
            icon = "https://openweathermap.org/img/wn/10d.png",
        )
        _weatherData.postValue(weather)
    }
}
