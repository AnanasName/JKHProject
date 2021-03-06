package com.example.jkhproject.ui.screens.billings

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.jkhproject.components.AppBottomMenu
import com.example.jkhproject.components.BottomMenu
import com.example.jkhproject.components.BottomMenuContent
import com.example.jkhproject.ui.screens.news.NewsAppBar
import com.example.jkhproject.util.Constants

@Composable
fun BillingsScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Column {
            Text(text = "Счета")
        }
        AppBottomMenu(navController = navController, initialSelectedItemIndex = 1, modifier = Modifier.align(Alignment.BottomCenter))
    }
}