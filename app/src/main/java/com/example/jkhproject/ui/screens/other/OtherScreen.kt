package com.example.jkhproject.ui.screens.other

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jkhproject.components.AppBottomMenu
import com.example.jkhproject.components.BottomMenu
import com.example.jkhproject.components.BottomMenuContent
import com.example.jkhproject.ui.screens.news.NewsAppBar
import com.example.jkhproject.ui.theme.cardBackground
import com.example.jkhproject.util.Constants

@ExperimentalFoundationApi
@Composable
fun OtherScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(
            modifier = Modifier.padding(
                start = 17.dp,
                end = 17.dp,
                top = 8.dp,
                bottom = 17.dp
            )
        ) {
            NewsAppBar()
            ControlCompanyRow()
            MessageBoard()

            val items = listOf(
                CardModel(),
                CardModel(icon = Icons.Filled.Email, title = "Контакты"),
                CardModel(icon = Icons.Filled.Info, title = "О приложении")
            )

            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth().fillMaxHeight()
            ) {
                items(items.size) {
                    Column(horizontalAlignment = Alignment.Start) {
                        CardForOtherScreen(icon = items[it].icon, title = items[it].title)
                    }
                }
            }
        }
        AppBottomMenu(
            navController = navController,
            initialSelectedItemIndex = 4,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun ControlCompanyRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = "ControlCompanyImage",
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
        )
        Spacer(modifier = Modifier.fillMaxWidth(0.05f))
        Text(
            text = "ООО \"Управляющия компания Вектор Энергоресурс\"",
            modifier = Modifier.fillMaxWidth(0.9f),
            style = MaterialTheme.typography.subtitle1
        )
        Icon(
            imageVector = Icons.Filled.ArrowForward,
            contentDescription = "ForwardIcon",
            modifier = Modifier.fillMaxWidth(0.5f)
        )
    }
}

@Composable
fun MessageBoard() {
    Card(
        shape = RoundedCornerShape(10), modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
            .height(280.dp), backgroundColor = MaterialTheme.colors.cardBackground
    ) {
        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                modifier = Modifier.padding(15.dp),
                text = "Доска объявлений",
                textAlign = TextAlign.Left,
                color = Color.White,
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Composable
fun CardForOtherScreen(
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Filled.Home,
    title: String = "Дом"
) {
    Card(
        shape = RoundedCornerShape(10),
        modifier = modifier.padding(top = 25.dp, start = 10.dp, end = 10.dp)
            .height(80.dp),
        backgroundColor = MaterialTheme.colors.background
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .padding(start = 10.dp)
            )
            Text(
                text = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp)
            )
        }
    }
}

private data class CardModel(
    val icon: ImageVector = Icons.Filled.Home,
    val title: String = "Дом"
)
