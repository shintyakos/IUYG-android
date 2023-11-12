package com.example.nextgenweatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.nextgenweatherapp.compose.NextGenWeatherApp
import com.example.nextgenweatherapp.ui.theme.NextGenWeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            NextGenWeatherAppTheme {
                NextGenWeatherApp()
            }
        }
    }
}
