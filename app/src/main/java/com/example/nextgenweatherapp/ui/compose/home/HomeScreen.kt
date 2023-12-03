package com.example.nextgenweatherapp.ui.compose.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nextgenweatherapp.R

private val pageCount = { 0 }
private const val ScreenName = "HomeScreen"

@Preview(device = "id:pixel_3")
@Composable
fun HomeScreen() {
    val pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0F, pageCount)
    Log.d(ScreenName, "${pagerState.currentPage}")
    Scaffold(
        topBar = { HomeTopBar() },
        bottomBar = { HomeBottomBar() },
        content = { HomePager(it) },
    )
}

@Composable
private fun HomeTopBar() {
    TopAppBar(
        windowInsets = AppBarDefaults.topAppBarWindowInsets,
        title = {
            Text(
                text = "Weather App",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(R.font.robotoflex_regular)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                ),
                modifier = Modifier
                    .width(272.dp)
                    .height(24.dp),
            )
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Notifications, contentDescription = "topNotifications")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Settings, contentDescription = "topSettings")
            }
        },
        modifier = Modifier
            .shadow(
                elevation = 6.dp,
                spotColor = Color(Color.Red.value),
                ambientColor = Color(Color.Red.value),
            )
            .background(color = Color(Color.White.value)),
    )
}

@Composable
private fun HomeBottomBar() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Settings")
    val itemMap = mapOf(
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
                    itemMap[item]?.let {
                        Icon(it, contentDescription = "bottom$item", tint = Color.Black)
                    }
                },
                label = { Text(item) },
            )
        }
    }
}

@Composable
private fun HomePager(padding: PaddingValues) {
    BoxWithConstraints {
        val screenHeight = with(LocalDensity.current) { constraints.maxHeight.toDp() }
        Log.d("", "$screenHeight")
    }
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
        modifier = Modifier
            .padding(padding)
            .fillMaxHeight(),
    ) {
        Box(modifier = Modifier.padding(top = 12.dp).weight(20.0f, true).fillMaxWidth()) {
            currentWeather()
        }
        Box(modifier = Modifier.weight(40.0f, true).fillMaxWidth()) {
            hourlyWeather()
        }
        Box(modifier = Modifier.weight(40.0f, true).fillMaxWidth()) {
            weeklyWeather()
        }
    }
}

/**
 *
 */
@Composable
private fun currentWeather() {
    Column {
        Box(modifier = Modifier.weight(40.0f, true).fillMaxWidth()) {
            secondTitle("現在の天気", true)
        }
        Box(modifier = Modifier.weight(60.0f, true).fillMaxWidth()) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize().padding(start = 12.dp, top = 16.dp, end = 12.dp),
            ) {
                Row(
                    modifier = Modifier
                        .weight(14.0f, true)
                        .fillMaxHeight()
                        .background(
                            color = Color(0x1A000000),
                            shape = RoundedCornerShape(100),
                        ),
                ) {}
                Column(
                    verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .weight(86.0f, true)
                        .fillMaxHeight(),
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Box(modifier = Modifier.fillMaxSize().weight(weight = 50.0f, fill = true)) {
                            Text(
                                text = "Tokyo, Japan",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    lineHeight = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.robotoflex_regular)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF000000),
                                ),
                                modifier = Modifier.align(Alignment.CenterStart),
                            )
                        }
                        Text(
                            text = "26°C",
                            style = TextStyle(
                                fontSize = 15.sp,
                                lineHeight = 15.sp,
                                fontFamily = FontFamily(Font(R.font.robotoflex_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0x80000000),
                            ),
                            modifier = Modifier.weight(50.0f, true).fillMaxWidth(),
                        )
                    }
                }
            }
        }
    }
}

/**
 *
 */
@Composable
private fun hourlyWeather() {
    Column {
        Box(modifier = Modifier.weight(20.0f, true).fillMaxWidth()) {
            secondTitle("時間ごとの天気")
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .weight(80.0f, true)
                .verticalScroll(rememberScrollState())
                .padding(start = 12.dp, end = 12.dp),
        ) {
            LazyColumn(modifier = Modifier.weight(25.0f, true)) {
                items(24) {
                    list()
                }
            }
        }
    }
}

/**
 *
 */
@Composable
private fun weeklyWeather() {
    Column {
        Box(modifier = Modifier.weight(20.0f, true).fillMaxWidth()) {
            secondTitle("週間ごとの天気", true)
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .weight(80.0f, true)
                .verticalScroll(rememberScrollState())
                .padding(start = 12.dp, end = 12.dp),
        ) {
            LazyColumn(modifier = Modifier.weight(25.0f, true)) {
                items(24) {
                    list()
                }
            }
        }
    }
}

@Composable
private fun secondTitle(title: String, isButton: Boolean = false) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 12.dp, top = 16.dp, end = 12.dp, bottom = 2.dp),
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.robotoflex_regular)),
                fontWeight = FontWeight(500),
                color = Color.Black,
            ),
            modifier = Modifier
                .weight(80.0f, true)
                .align(Alignment.CenterVertically),
        )
        if (isButton) {
            IconButton({}) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFF000000),
                            shape = RoundedCornerShape(size = 4.dp),
                        )
                        .weight(20.0f, true)
                        .padding(start = 8.dp, top = 3.dp, end = 4.dp, bottom = 3.dp),
                ) {
                    Text(
                        text = "Details",
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            fontFamily = FontFamily(Font(R.font.robotoflex_regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                        ),
                        modifier = Modifier
                            .padding(1.dp)
                            .width(37.dp)
                            .height(16.dp),
                    )
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = "Details",
                        modifier = Modifier
                            .padding(1.dp)
                            .width(12.dp)
                            .height(12.dp),
                    )
                }
            }
        }
    }
}

@Composable
private fun list() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(top = 12.dp, bottom = 12.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(32.dp)
                .height(32.dp)
                .background(color = Color(0x0D000000), shape = RoundedCornerShape(size = 16.dp)),
        ) {
            Icon(
                Icons.Filled.Home,
                contentDescription = "hourlyWeather",
                modifier = Modifier
                    .padding(1.dp)
                    .width(30.dp)
                    .height(30.dp),
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .width(296.dp)
                .height(36.dp),
        ) {
            Text(
                text = "12 PM",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(Font(R.font.robotoflex_regular)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                ),
                modifier = Modifier
                    .width(296.dp)
                    .height(20.dp),
            )
            Text(
                text = "28°C",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Font(R.font.robotoflex_regular)),
                    fontWeight = FontWeight(400),
                    color = Color(0x80000000),
                ),
                modifier = Modifier
                    .width(296.dp)
                    .height(16.dp),
            )
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .border(width = 1.dp, color = Color(0x1A000000)),
    ) {}
}
