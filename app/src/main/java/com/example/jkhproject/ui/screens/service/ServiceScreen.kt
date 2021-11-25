package com.example.jkhproject.ui.screens.service

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jkhproject.components.AppBottomMenu
import com.example.jkhproject.components.BottomMenu
import com.example.jkhproject.components.BottomMenuContent
import com.example.jkhproject.ui.screens.news.NewsAppBar
import com.example.jkhproject.ui.theme.cardBackground
import com.example.jkhproject.ui.theme.serviceHeadItemBackgroundColor
import com.example.jkhproject.ui.theme.serviceScreenHeaderColor
import com.example.jkhproject.ui.theme.serviceSearchBarColor
import com.example.jkhproject.util.Constants

@Composable
fun ServiceScreen(
    navController: NavController
) {
    val searchTextState = remember { mutableStateOf(TextFieldValue("")) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Column {
            ServiceHeader(state = searchTextState)
            ServiceContent(modifier = Modifier.padding(horizontal = 17.dp))
        }
        AppBottomMenu(
            navController = navController,
            initialSelectedItemIndex = 0,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun ServiceHeader(state: MutableState<TextFieldValue>) {
    Column(
        modifier = Modifier
            .fillMaxHeight(0.4f)
            .background(color = MaterialTheme.colors.serviceScreenHeaderColor)
            .padding(
                start = 17.dp,
                end = 17.dp,
                top = 24.dp,
                bottom = 17.dp
            )
    ) {
        ServiceAppBar()
        Box(modifier = Modifier.padding(top = 24.dp)) {
            SearchView(state = state)
        }
        Row(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ServiceHeaderItem(title = "Вызов специалиста", icon = Icons.Filled.Call)
            ServiceHeaderItem(title = "Задать вопрос", icon = Icons.Filled.AccountCircle)
            ServiceHeaderItem(title = "Сообщить о проблеме", icon = Icons.Filled.Warning)
            ServiceHeaderItem(title = "Другое", icon = Icons.Filled.MoreVert)
        }
    }

}

@Composable
fun ServiceAppBar() {
    Row(
        modifier = Modifier.fillMaxHeight(0.16f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .height(50.dp)
                .width(50.dp),
            imageVector = Icons.Filled.Person,
            tint = Color.White,
            contentDescription = "Person Icon"
        )
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = "События",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun SearchView(state: MutableState<TextFieldValue>) {
    TextField(
        placeholder = { Text("Поиск услуг...", color = Color.White) },
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            if (state.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        state.value =
                            TextFieldValue("") // Remove text from TextField when you press the 'X' icon
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(8.dp), // The TextFiled has rounded corners top left and right by default
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.White,
            backgroundColor = MaterialTheme.colors.serviceSearchBarColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun ServiceHeaderItem(title: String, icon: ImageVector) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            modifier = Modifier
                .height(70.dp)
                .width(70.dp)
                .background(
                    MaterialTheme.colors.serviceHeadItemBackgroundColor,
                    shape = RoundedCornerShape(50)
                )
                .padding(10.dp),
            imageVector = icon,
            contentDescription = title,
            tint = Color.White
        )
        Text(
            text = title,
            color = Color.White,
            modifier = Modifier.width(86.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle2
        )
    }
}

@Composable
fun ServiceContent(modifier: Modifier = Modifier) {
    val serviceModels by remember {
        mutableStateOf(
            listOf(
                ServiceItemModel("Мастер на час", listOf("Выезд специалиста")),
                ServiceItemModel("Чистота и порядок", listOf("Дополнительные услуги по клинингу", "Мытье окон")),
                ServiceItemModel("Недвижимость", listOf("Недвижимость")),
                ServiceItemModel("Бытовые услуги", listOf("Вынос мусора", "Консультация", "1 человеко-час специалиста", "Вынос мусора")),
                ServiceItemModel("Системы для дома", listOf("Кодоносители", "Работы по системам", "Система дымаухода", "Вынос мусора")),
                ServiceItemModel("Строительство и ремонт", listOf("Плотницкие работы (двери)", "Плотницкие работы (демонтаж)", "Плотницкие работы (монтаж)", "Вынос мусора")),
            )
        )
    }
    LazyColumn(
        modifier = modifier.padding(top = 30.dp, bottom = 100.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(serviceModels) { serviceModel ->
            Text(text = serviceModel.title, style = MaterialTheme.typography.h6)
            LazyRow(horizontalArrangement = Arrangement.spacedBy(9.dp)) {
                items(serviceModel.listOfSubtitles) { title ->
                    ServiceCardItem(title = title)
                }
            }
        }
    }
}

@Composable
fun ServiceCardItem(title: String) {
    Card(
        shape = RoundedCornerShape(10), modifier = Modifier
            .widthIn(max = 300.dp, min = 300.dp)
            .height(150.dp)
            .padding(top = 27.dp), backgroundColor = MaterialTheme.colors.cardBackground
    ) {
        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                modifier = Modifier.padding(15.dp),
                text = title,
                textAlign = TextAlign.Left,
                color = Color.White,
                style = MaterialTheme.typography.h6
            )
        }
    }

}

data class ServiceItemModel(
    val title: String,
    val listOfSubtitles: List<String>
)

@Preview
@Composable
fun ServiceContentPreview() {
    ServiceContent()
}