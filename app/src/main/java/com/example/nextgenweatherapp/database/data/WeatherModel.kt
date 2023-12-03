package com.example.nextgenweatherapp.database.data

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

open class WeatherModel : RealmObject {
    @PrimaryKey
    var weatherId: Int = 0
    var cityName: String = ""
    var temperature: Double = 0.0
    var weatherDescription: String = ""
    var icon: String = ""
}

