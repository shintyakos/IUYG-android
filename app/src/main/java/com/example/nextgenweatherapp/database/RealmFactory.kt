package com.example.nextgenweatherapp.database

import com.example.nextgenweatherapp.database.data.WeatherModel
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

object RealmFactory {
    private lateinit var realm: Realm

    fun getRealmInstance(): Realm {
        if (!::realm.isInitialized) {
            initRealm()
        }

        return realm
    }

    private fun initRealm() {
        val config = RealmConfiguration.Builder(schema = setOf(WeatherModel::class))
            .name("weather.realm")
            .schemaVersion(1)
            .build()
        realm = Realm.open(config)
    }
}
