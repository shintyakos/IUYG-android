package com.example.nextgenweatherapp.ui.compose

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nextgenweatherapp.repository.RepositoryFactory
import com.example.nextgenweatherapp.ui.compose.home.HomeScreen
import com.example.nextgenweatherapp.ui.viewmodel.HomeViewModel

@Composable
fun NextGenWeatherApp() {
    val homeViewModel = HomeViewModel(RepositoryFactory.getWeatherRepository())
    val navController = rememberNavController()
    NextGenWeatherNavHost(navController, homeViewModel)
}

@Composable
fun NextGenWeatherNavHost(navController: NavHostController, homeViewModel: HomeViewModel) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(homeViewModel)
        }
    }
}
