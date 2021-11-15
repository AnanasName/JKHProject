package com.example.jkhproject.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

//Изменить цвета для темной темы

val Colors.highlightIconColor: Color
    @Composable
    get() = if (isLight) Color(0xffffa000) else Color(0xffffa000)

val Colors.highlightTextColor: Color
    @Composable
    get() = if (isLight) Color(0xffca9885) else Color(0xffffa000)

val Colors.statusBarColor: Color
    @Composable
    get () = if (isLight) Color(0xFFD6D6D6) else Color.DarkGray

val Colors.navBarDividerColor: Color
    @Composable
    get() = if (isLight)  Color(0x88D6D6D6) else Color.DarkGray

val Colors.newsItemBackgroundColor: Color
    @Composable
    get() = if (isLight) Color(0xFFF3F3F3) else Color.DarkGray

val Colors.newsItemSubtitleColor: Color
    @Composable
    get() = if (isLight) Color(0xffd3d3d3) else Color.DarkGray

val Colors.cardBackground: Color
    @Composable
    get() = if (isLight) Color(0xffa9acb3) else Color.DarkGray

val Colors.serviceScreenHeaderColor: Color
    @Composable
    get() = if (isLight) Color(0xffa9acb3) else Color.DarkGray

val Colors.serviceSearchBarColor: Color
    @Composable
    get() = if (isLight) Color(0x33635F5F) else Color(0x80000000)

val Colors.serviceHeadItemBackgroundColor: Color
    @Composable
    get() = if (isLight) Color(0x33635F5F) else Color(0x80000000)