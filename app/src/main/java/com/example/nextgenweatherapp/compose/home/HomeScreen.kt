package com.example.nextgenweatherapp.compose.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable

private val pageCount = { 0 }
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    val pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0F, pageCount)
}
