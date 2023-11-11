package com.example.nextgenweatherapp.compose

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nextgenweatherapp.compose.home.HomeScreen

@Composable
fun NextGenWeatherApp() {
    val navController = rememberNavController()
    NextGenWeatherNavHost(navController)
}

@Composable
fun NextGenWeatherNavHost(navController: NavHostController) {
    val activity = (LocalContext.current as Activity)
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
    }
}