/**
 * WeatherRepository.kt
 * This is the repository class which will be used to fetch the data from the API.
 * This class will be used to fetch the data from the API and then pass it to the ViewModel.
 * @param - None
 * @return - None
 */
package com.example.nextgenweatherapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nextgenweatherapp.api.RetrofitService
import com.example.nextgenweatherapp.api.response.CityCodeResponse
import com.example.nextgenweatherapp.model.Weather
import com.example.nextgenweatherapp.repository.interfaces.IWeatherRepository
import retrofit2.Response

class WeatherRepository : IWeatherRepository {
    val isLoding = MutableLiveData<Boolean>()

    override fun getCurrentWeather(): LiveData<Weather> {
        val response: Response<CityCodeResponse> = RetrofitService.weatherService.getCityCoordinates(
            cityName = "Tokyo"
        ).execute()
        return MutableLiveData<Weather>()
    }

    override fun getHourlyWeather(): LiveData<Weather> {
        TODO("Not yet implemented")
    }

    override fun getWeeklyWeather(): LiveData<Weather> {
        TODO("Not yet implemented")
    }
}
