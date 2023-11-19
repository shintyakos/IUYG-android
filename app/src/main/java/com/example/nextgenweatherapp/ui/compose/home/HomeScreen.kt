package com.example.nextgenweatherapp.ui.compose.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

private val pageCount = { 0 }

@Composable
fun HomeScreen() {
    val pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0F, pageCount)
    Scaffold(
        topBar = { HomeTopBar() },
        bottomBar = { HomeBottomBar() },
    ) {
        it.let {
            Log.d("HomeScreen", "it: $it")
        }
        HomePager(pagerState = pagerState)
    }
}

@Composable
private fun HomeTopBar() {
    TopAppBar(
        windowInsets = AppBarDefaults.topAppBarWindowInsets,
        title = {
            Text("Weather App")
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Settings, contentDescription = "topSettings")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Notifications, contentDescription = "topNotifications")
            }
        }
    )
}

// private fun HomeContent(value: PaddingValues) {}

@Composable
private fun HomeBottomBar() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Settings")
    val itemMap = mapOf<String, ImageVector>(
        "Home" to Icons.Filled.Home,
        "Settings" to Icons.Filled.Settings,
    )

    BottomNavigation(windowInsets = BottomNavigationDefaults.windowInsets) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                modifier = Modifier.background(Color.White),
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                icon = {
                    itemMap.get(item)?.let {
                        Icon(it, contentDescription = "bottom$item", tint = Color.Black)
                    }
                },
                label = { Text(item) },
            )
        }
    }
}

private fun HomePager(pagerState: Any) {
    Log.d("HomePager", "pagerState: $pagerState")
}
