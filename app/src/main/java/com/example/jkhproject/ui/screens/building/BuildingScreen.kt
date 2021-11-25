package com.example.jkhproject.ui.screens.building

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jkhproject.components.AppBottomMenu
import com.example.jkhproject.components.BottomMenu
import com.example.jkhproject.components.BottomMenuContent
import com.example.jkhproject.ui.screens.news.NewsAppBar
import com.example.jkhproject.ui.theme.serviceSearchBarColor
import com.example.jkhproject.util.Constants

@Composable
fun BuildingScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        Column(
            modifier = Modifier.padding(
                start = 17.dp,
                end = 17.dp,
                top = 6.dp,
                bottom = 17.dp
            )
        ) {
            BuildingAppBar()
            CounterCard()
            Box(
                modifier = Modifier
                    .background(
                        Color.DarkGray,
                        RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp)
                    )
                    .padding(start = 17.dp, end = 17.dp)
                    .fillMaxWidth(),
            ) {
                Text(text = "Активные")
            }
        }
        AppBottomMenu(
            navController = navController,
            initialSelectedItemIndex = 2,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun BuildingAppBar() {
    Row(
        modifier = Modifier.fillMaxHeight(0.1f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .height(50.dp)
                .width(50.dp),
            imageVector = Icons.Filled.Person,
            contentDescription = "Person Icon"
        )
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = "Помещение",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
    }

}

@Composable
fun CounterCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.serviceSearchBarColor, shape = RoundedCornerShape(10))
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(0.7f),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier.padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.Info, contentDescription = "CountersIcon")
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "Счётчики",
                    style = MaterialTheme.typography.h6
                )
            }
            Text(text = "Передайте показания до 25.05", style = MaterialTheme.typography.subtitle2)

        }
        Icon(
            modifier = Modifier
                .height(35.dp)
                .width(35.dp),
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "ForwardIcon"
        )
    }
}

@Composable
@Preview
fun CounterCardPreview() {
    CounterCard()
}