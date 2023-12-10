package com.example.nextgenweatherapp.api.response

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("queryCost")
    val queryCost: String,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("resolvedAddress")
    val resolvedAddress: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("timezoneName")
    val timezoneName: String,
    @SerializedName("days")
    val days: List<Day>,
    @SerializedName("alerts")
    val alerts: List<String>,
    @SerializedName("currentConditions")
    val currentConditions: CurrentCondition,
)

data class Day(
    val datetime: String,
    val datetimeEpoch: Int,
    val tempmax: Double,
    val tempmin: Double,
    val temp: Double,
    val feelslikemax: Double,
    val feelslikemin: Double,
    val feelslike: Double,
    val dew: Double,
    val humidity: Double,
    val precip: Double,
    val precipprob: Double,
    val precipcover: Double,
    val preciptype: List<String>?,
    val snow: Double?,
    val snowdepth: Double?,
    val windgust: Double,
    val windspeed: Double,
    val winddir: Double,
    val pressure: Double,
    val cloudcover: Double,
    val visibility: Double,
    val solarradiation: Double,
    val solarenergy: Double,
    val uvindex: Double,
    val sunrise: String,
    val sunriseEpoch: Int,
    val sunset: String,
    val sunsetEpoch: Int,
    val moonphase: Double,
    val conditions: String,
    val description: String,
    val icon: String,
    val stations: List<String>,
    val source: String,
    val hours: List<Hour>,
    val precipsum: Double,
    val precipsumnormal: Double,
    val snowsum: Double,
    val datetimeInstance: String

)

data class Hour(
    val datetime: String,
    val datetimeEpoch: Int,
    val temp: Double,
    val feelslike: Double,
    val dew: Double,
    val humidity: Double,
    val precip: Double,
    val precipprob: Double,
    val precipcover: Double,
    val preciptype: List<String>?,
    val snow: Double?,
    val snowdepth: Double?,
    val windgust: Double,
    val windspeed: Double,
    val winddir: Double,
    val pressure: Double,
    val cloudcover: Double,
    val visibility: Double,
    val solarradiation: Double,
    val solarenergy: Double,
    val uvindex: Double,
    val conditions: String,
    val description: String,
    val icon: String,
    val stations: List<String>,
    val source: String,
    val datetimeInstance: String
)

data class CurrentCondition(
    val datetime: String,
    val datetimeEpoch: Int,
    val temp: Double,
    val feelslike: Double,
    val dew: Double,
    val humidity: Double,
    val precip: Double,
    val precipprob: Double,
    val snow: Double?,
    val snowdepth: Double?,
    val preciptype: List<String>?,
    val windgust: Double,
    val windspeed: Double,
    val winddir: Double,
    val pressure: Double,
    val visibility: Double,
    val cloudcover: Double,
    val solarradiation: Double,
    val solarenergy: Double,
    val uvindex: Double,
    val conditions: String,
    val icon: String,
    val stations: List<String>,
    val source: String,
    val sunrise: String,
    val sunriseEpoch: Int,
    val sunset: String,
    val sunsetEpoch: Int,
    val moonphase: Double
)
