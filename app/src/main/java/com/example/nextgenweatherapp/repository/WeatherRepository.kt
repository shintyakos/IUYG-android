/**
 * WeatherRepository.kt
 * This is the repository class which will be used to fetch the data from the API.
 * This class will be used to fetch the data from the API and then pass it to the ViewModel.
 * @param - None
 * @return - None
 */
package com.example.nextgenweatherapp.repository

import com.example.nextgenweatherapp.api.RetrofitService
import com.example.nextgenweatherapp.api.response.CityCodeResponse
import com.example.nextgenweatherapp.api.response.WeatherResponse
import com.example.nextgenweatherapp.database.RealmFactory
import com.example.nextgenweatherapp.database.data.WeatherModel
import com.example.nextgenweatherapp.repository.interfaces.IWeatherRepository
import retrofit2.Response

class WeatherRepository : IWeatherRepository {
    /**
     * getCurrentWeather() function is used to fetch the current weather data from the API.
     * @param - None
     * @return - WeatherResponse? 現在の天気データを返すか、またはnullを返す
     */
    override suspend fun getCurrentWeather(): WeatherResponse? {
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
                        val weatherModel = WeatherModel().apply {
                            this.weatherId = 0
                            this.cityName = "Tokyo"
                            this.temperature = weather.main.temp
                            this.weatherDescription = weather.weather.description
                            this.icon = weather.weather.icon
                        }
                        saveWeatherDataToRealm(weatherModel)
                        return weather
                    }
                }
            }
        }

        return null
    }

    private fun saveWeatherDataToRealm(weather: WeatherModel) {
        val realm = RealmFactory.getRealmInstance()
        realm.writeBlocking {
            copyToRealm(weather)
        }
        realm.close()
    }

    override suspend fun getHourlyWeather() {
        TODO("Not yet implemented")
    }

    override suspend fun getWeeklyWeather() {
        TODO("Not yet implemented")
    }
}
