package com.example.jkhproject.ui.screens.news

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jkhproject.components.AppBottomMenu
import com.example.jkhproject.components.NewsItem
import com.example.jkhproject.data.models.News
import com.example.jkhproject.data.models.network.NewsNetModel
import com.example.jkhproject.ui.viewmodels.NewsViewModel

@ExperimentalMaterialApi
@Composable
fun NewsScreen(
    newsViewModel: NewsViewModel,
    navController: NavController
) {

    val allNews by newsViewModel.news.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Column(modifier = Modifier.padding(start = 17.dp, end = 17.dp, top = 6.dp, bottom=17.dp)) {
            NewsAppBar()
            ListContent(
                newsList = allNews
            )
        }
        AppBottomMenu(
            navController = navController,
            initialSelectedItemIndex = 3,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@ExperimentalMaterialApi
@Composable
fun ListContent(
    newsList: List<NewsNetModel>,
) {
    Box(modifier = Modifier
        .fillMaxHeight(0.89f)
        .background(Color.White)) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)){
            items(
                newsList
            ) { newsItem ->
                NewsItem(newsItem = newsItem)
            }
        }
    }
}

@Composable
fun NewsAppBar() {
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
            text = "События",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
    }

}


@Preview
@Composable
fun NewsScreenPreview() {
    NewsAppBar()
}