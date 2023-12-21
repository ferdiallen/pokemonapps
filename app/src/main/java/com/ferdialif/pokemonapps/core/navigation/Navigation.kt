package com.ferdialif.pokemonapps.core.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ferdialif.pokemonapps.presentation.detail.DetailScreen
import com.ferdialif.pokemonapps.presentation.home.HomeScreen
import com.ferdialif.pokemonapps.presentation.start.StartScreen

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    controller: NavHostController = rememberNavController()
) {
    NavHost(modifier = modifier,navController = controller, startDestination = NavigationName.StartScreen.route) {
        composable(route = NavigationName.StartScreen.route, exitTransition = {
            slideOutHorizontally(tween(400), targetOffsetX = {
                -it + 500
            })
        }) {
            StartScreen(modifier = Modifier.fillMaxSize(), onNavigateToHomeScreen = {
                controller.navigate(NavigationName.HomeScreen.route){
                    launchSingleTop =  true
                    this.popUpTo(NavigationName.StartScreen.route){
                        inclusive = true
                    }
                }
            })
        }
        composable(route = NavigationName.HomeScreen.route, enterTransition = {
            fadeIn(tween(400))
        }) {
            HomeScreen(modifier = Modifier.fillMaxSize(),
                onNavigateToDetailScreen = {
                controller.navigate(NavigationName.DetailScreen.route+"/$it")
                })
        }
        composable(route = NavigationName.DetailScreen.route + "/{name}") {
            DetailScreen(
                modifier = Modifier.fillMaxSize(),
                onNavigateBack = { controller.popBackStack() })
        }
    }

}