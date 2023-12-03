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
import com.example.nextgenweatherapp.api.response.WeatherResponse
import com.example.nextgenweatherapp.database.RealmFactory
import com.example.nextgenweatherapp.database.data.WeatherModel
import com.example.nextgenweatherapp.model.Weather
import com.example.nextgenweatherapp.repository.interfaces.IWeatherRepository
import retrofit2.Response

class WeatherRepository : IWeatherRepository {
    val isLoding = MutableLiveData<Boolean>()

    /**
     * getCurrentWeather() function is used to fetch the current weather data from the API.
     * @param - None
     * @return - None
     */
    override suspend fun getCurrentWeather() {
        val cityCodeResponse: Response<CityCodeResponse> = RetrofitService.weatherService.getCityCoordinates(
            cityName = "Tokyo",
        ).execute()
        if (cityCodeResponse.isSuccessful) {
            cityCodeResponse.body()?.let { cityCode ->
                val weatherResponse = RetrofitService.weatherService.getCurrentWeather(
                    lat = cityCode.lat.toString(),
                    lon = cityCode.lon.toString(),
                ).execute()
                if (weatherResponse.isSuccessful) {
                    weatherResponse.body()?.let { weather ->
                        saveWeatherDataToRealm(weather)
                    }
                }
            }
        }
    }

    private fun saveWeatherDataToRealm(weather: WeatherResponse) {
        val realm = RealmFactory.getRealmInstance()
        realm.writeBlocking {
            copyToRealm(WeatherModel().apply {
                this.weatherId = 0
                this.cityName = "Tokyo"
                this.temperature = weather.main.temp
                this.weatherDescription = weather.weather.description
                this.icon = weather.weather.icon
            })
        }
    }

    override suspend fun getHourlyWeather() {
        TODO("Not yet implemented")
    }

    override suspend fun getWeeklyWeather() {
        TODO("Not yet implemented")
    }

}
