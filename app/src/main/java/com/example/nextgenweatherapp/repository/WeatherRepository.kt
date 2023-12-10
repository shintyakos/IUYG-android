/**
 * WeatherRepository.kt
 * This is the repository class which will be used to fetch the data from the API.
 * This class will be used to fetch the data from the API and then pass it to the ViewModel.
 * @param - None
 * @return - None
 */
package com.example.nextgenweatherapp.repository

import com.example.nextgenweatherapp.api.RetrofitService
import com.example.nextgenweatherapp.api.response.WeatherResponse
import com.example.nextgenweatherapp.database.RealmFactory
import com.example.nextgenweatherapp.database.data.WeatherModel
import com.example.nextgenweatherapp.repository.interfaces.IWeatherRepository
import io.realm.kotlin.delete
import retrofit2.Response

class WeatherRepository() : IWeatherRepository {
    /**
     * getCurrentWeather() function is used to fetch the current weather data from the API.
     * @param - None
     * @return - WeatherResponse? 現在の天気データを返すか、またはnullを返す
     */
    override suspend fun getCurrentWeather(): WeatherModel? {
        val weatherResponse: Response<WeatherResponse> = RetrofitService.weatherService.getWeather().execute()
        if (weatherResponse.isSuccessful) {
            val weather = weatherResponse.body()?.let {
                WeatherModel().apply {
                    weatherId = 0
                    cityName = it.resolvedAddress
                    temperature = it.currentConditions.temp
                    weatherDescription = it.currentConditions.conditions
                    icon = it.currentConditions.icon
                }
            }
            weather?.let { saveWeatherDataToRealm(it) }
            return weather
        }
        return null
    }

    private fun saveWeatherDataToRealm(weather: WeatherModel) {
        val realm = RealmFactory.getRealmInstance()
        realm.writeBlocking {
            delete<WeatherModel>()
            copyToRealm(weather)
        }
        realm.close()
    }
}
