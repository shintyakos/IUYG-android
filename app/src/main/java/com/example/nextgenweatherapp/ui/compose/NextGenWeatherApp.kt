package com.example.nextgenweatherapp.ui.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nextgenweatherapp.ui.compose.home.HomeScreen

@Composable
fun NextGenWeatherApp() {
    val navController = rememberNavController()
    NextGenWeatherNavHost(navController)
}

@Composable
fun NextGenWeatherNavHost(navController: NavHostController) {
//    val activity = (LocalContext.current as Activity)
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
    }
}
