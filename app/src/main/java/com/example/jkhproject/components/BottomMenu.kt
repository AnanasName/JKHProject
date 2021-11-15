package com.example.jkhproject.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jkhproject.ui.theme.highlightIconColor
import com.example.jkhproject.ui.theme.highlightTextColor
import com.example.jkhproject.ui.theme.navBarDividerColor
import com.example.jkhproject.ui.theme.statusBarColor
import com.example.jkhproject.util.Constants

@Composable
fun AppBottomMenu(
    modifier: Modifier = Modifier,
    initialSelectedItemIndex: Int = 0,
    navController: NavController,
) {
    BottomMenu(
        initialSelectedItemIndex = initialSelectedItemIndex,
        items = listOf(
            BottomMenuContent("Сервис", Icons.Filled.Notifications, onItemClick = {
                navController.navigate(
                    Constants.SERVICE_SCREEN
                )
            }),
            BottomMenuContent("Счета", Icons.Filled.ShoppingCart, onItemClick = {
                navController.navigate(
                    Constants.BILLINGS_SCREEN
                )
            }),
            BottomMenuContent("Помещение", Icons.Filled.Home, onItemClick = {
                navController.navigate(
                    Constants.BUILDING_SCREEN
                )
            }),
            BottomMenuContent(
                "События",
                Icons.Filled.Menu,
                onItemClick = { navController.navigate(Constants.NEWS_SCREEN) }),
            BottomMenuContent("Ещё", Icons.Filled.Info, onItemClick = {
                navController.navigate(
                    Constants.OTHER_SCREEN
                )
            }),
        ), modifier = modifier
    )
}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeTextColor: Color = MaterialTheme.colors.highlightTextColor,
    inactiveTextColor: Color = Color.Gray,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Column(modifier = modifier) {
        Divider(color = MaterialTheme.colors.navBarDividerColor, thickness = 1.dp)
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(15.dp)
        ) {
            items.forEachIndexed { index, item ->
                BottomMenuItem(
                    item = item,
                    isSelected = index == selectedItemIndex,
                    activeTextColor = activeTextColor,
                    inactiveTextColor = inactiveTextColor
                ) {
                    selectedItemIndex = index
                    item.onItemClick()
                }
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeTextColor: Color = MaterialTheme.colors.highlightTextColor,
    inactiveTextColor: Color = Color.Gray,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .padding(10.dp)
        ) {
            Icon(
                imageVector = item.iconImage,
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor
        )
    }
}


data class BottomMenuContent(
    val title: String,
    val iconImage: ImageVector,
    val onItemClick: () -> Unit,
)