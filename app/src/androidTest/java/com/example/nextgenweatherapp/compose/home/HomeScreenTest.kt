package com.example.nextgenweatherapp.compose.home

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.example.nextgenweatherapp.ui.theme.NextGenWeatherAppTheme
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun topBarDisplaysItems() {
        composeTestRule.setContent {
            NextGenWeatherAppTheme {
                HomeScreen()
            }
        }
        composeTestRule.onNodeWithText("Weather App").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Settings").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Notifications").assertIsDisplayed()
    }

    @Test
    fun bottomBarDisplaysItems() {
        composeTestRule.setContent {
            NextGenWeatherAppTheme {
                HomeScreen()
            }
        }
        composeTestRule.onNodeWithContentDescription("Home").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Favorites").assertIsDisplayed()
    }
}
