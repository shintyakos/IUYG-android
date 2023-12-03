package com.example.nextgenweatherapp.database.data

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class CityCodeData : RealmObject {
    @PrimaryKey
    val name: String = ""
    val lat: Double = 0.0
    val lon: Double = 0.0
    val country: String = ""
    val state: String = ""
}
