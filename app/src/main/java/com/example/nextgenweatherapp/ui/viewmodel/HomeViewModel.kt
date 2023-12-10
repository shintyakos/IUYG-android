/**
 * HomeViewModel.kt
 * 天気情報に関するビジネスロジックを記述する
 */
package com.example.nextgenweatherapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nextgenweatherapp.R
import com.example.nextgenweatherapp.model.Weather
import com.example.nextgenweatherapp.repository.interfaces.IWeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val weatherRepository: IWeatherRepository) : ViewModel() {
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
                        cityName = it.cityName,
                        temperature = "${it.temperature}℃",
                        weatherDescription = it.weatherDescription,
                        icon = getIconResources(it.icon),
                    )
                    _weatherData.postValue(weather)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun getIconResources(iconName: String): Int {
        return when (iconName) {
            "clear-day" -> R.drawable.clear_day
            "clear-night" -> R.drawable.clear_night
            "cloudy" -> R.drawable.cloudy
            "fog" -> R.drawable.fog
            "hail" -> R.drawable.hail
            "partly-cloudy-day" -> R.drawable.partly_cloudy_day
            "partly-cloudy-night" -> R.drawable.partly_cloudy_night
            "rain" -> R.drawable.rain
            "rain-snow" -> R.drawable.rain_snow
            "rain-snow-showers-day" -> R.drawable.rain_snow_showers_day
            "rain-snow-showers-night" -> R.drawable.rain_snow_showers_night
            "showers-day" -> R.drawable.showers_day
            "showers-night" -> R.drawable.showers_night
            "sleet" -> R.drawable.sleet
            "snow" -> R.drawable.snow
            "snow-showers-day" -> R.drawable.snow_showers_day
            "snow-showers-night" -> R.drawable.snow_showers_night
            "thunder" -> R.drawable.thunder
            "thunder-rain" -> R.drawable.thunder_rain
            "thunder-showers-day" -> R.drawable.snow_showers_day
            "thunder-showers-night" -> R.drawable.snow_showers_night
            "wind" -> R.drawable.wind
            else -> R.drawable.clear_day
        }
    }
}
