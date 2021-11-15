package com.example.jkhproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jkhproject.ui.screens.billings.BillingsScreen
import com.example.jkhproject.ui.screens.building.BuildingScreen
import com.example.jkhproject.ui.screens.news.NewsScreen
import com.example.jkhproject.ui.screens.other.OtherScreen
import com.example.jkhproject.ui.screens.service.ServiceScreen
import com.example.jkhproject.ui.theme.JKHProjectTheme
import com.example.jkhproject.ui.viewmodels.NewsViewModel
import com.example.jkhproject.util.Constants.BILLINGS_SCREEN
import com.example.jkhproject.util.Constants.BUILDING_SCREEN
import com.example.jkhproject.util.Constants.NEWS_SCREEN
import com.example.jkhproject.util.Constants.OTHER_SCREEN
import com.example.jkhproject.util.Constants.SERVICE_SCREEN
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {


    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController: NavHostController = rememberNavController()
            val newsViewModel: NewsViewModel by viewModels()
            JKHProjectTheme {
                NavHost(navController = navController, startDestination = NEWS_SCREEN){
                    composable(SERVICE_SCREEN){
                        ServiceScreen(navController = navController)
                    }
                    composable(BILLINGS_SCREEN){
                        BillingsScreen(navController = navController)
                    }
                    composable(BUILDING_SCREEN){
                        BuildingScreen(navController = navController)
                    }
                    composable(NEWS_SCREEN){
                        NewsScreen(newsViewModel = newsViewModel, navController = navController)
                    }
                    composable(OTHER_SCREEN){
                        OtherScreen(navController = navController)
                    }
                }
            }
        }
    }
}