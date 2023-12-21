package com.ferdialif.pokemonapps.core.navigation

sealed class NavigationName(val route:String) {
    data object StartScreen:NavigationName("start_screen")
    data object HomeScreen:NavigationName("home_screen")
    data object DetailScreen:NavigationName("detail_screen")
}