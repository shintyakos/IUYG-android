package com.example.nextgenweatherapp.database.data

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class WeatherData : RealmObject {
    @PrimaryKey
    var watherId: Int = 0
}
