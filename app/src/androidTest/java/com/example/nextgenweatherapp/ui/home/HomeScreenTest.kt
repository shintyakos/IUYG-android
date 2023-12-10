package com.example.nextgenweatherapp.ui.home

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.example.nextgenweatherapp.repository.RepositoryFactory
import com.example.nextgenweatherapp.repository.interfaces.IWeatherRepository
import com.example.nextgenweatherapp.ui.compose.home.HomeScreen
import com.example.nextgenweatherapp.ui.theme.NextGenWeatherAppTheme
import com.example.nextgenweatherapp.ui.viewmodel.HomeViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var weatherService: IWeatherRepository

    @Before
    fun setUp() {
        weatherService = RepositoryFactory.getPreviewWeatherRepository()
        homeViewModel = HomeViewModel(weatherService)
    }

    @Test
    fun topBarDisplaysItems() {
        composeTestRule.setContent {
            NextGenWeatherAppTheme {
                HomeScreen(homeViewModel)
            }
        }
        composeTestRule.onNodeWithText("Weather App").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("topSettings").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("topNotifications").assertIsDisplayed()
    }

    @Test
    fun bottomBarDisplaysItems() {
        composeTestRule.setContent {
            NextGenWeatherAppTheme {
                HomeScreen(homeViewModel)
            }
        }
        composeTestRule.onNodeWithContentDescription("bottomHome").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("bottomSettings").assertIsDisplayed()
    }
}
