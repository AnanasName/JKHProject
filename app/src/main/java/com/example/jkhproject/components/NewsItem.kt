package com.example.jkhproject.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jkhproject.data.models.News
import com.example.jkhproject.ui.theme.highlightTextColor
import com.example.jkhproject.ui.theme.newsItemBackgroundColor
import com.example.jkhproject.ui.theme.newsItemSubtitleColor

@Composable
fun NewsItem(
    newsItem: News
) {
    Box( modifier = Modifier.background(MaterialTheme.colors.newsItemBackgroundColor, shape = RoundedCornerShape(8.dp)).padding(14.dp)){
        Column(verticalArrangement = Arrangement.Center) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(text = "НОВОСТЬ", color = MaterialTheme.colors.highlightTextColor, fontWeight = FontWeight.Bold)
                Text(text = newsItem.date)
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = newsItem.title,
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = newsItem.subDescription,
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.newsItemSubtitleColor
            )
        }

    }
}

@Preview
@Composable
fun NewsItemPreview() {
    NewsItem(
        News(
            title = "Доска объявлений",
            subDescription = "Или как начать дружить с соседями",
            date = "17 марта",
            description = "dasjghlsdfghskdgd"
        )
    )
}