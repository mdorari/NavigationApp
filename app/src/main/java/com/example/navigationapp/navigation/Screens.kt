package com.example.navigationapp.navigation

enum class Screens {
    HomeScreen,
    DetailsScreen,
    ProfileScreen;

    companion object {
        fun fromRoute(route: String?): Screens
        = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            ProfileScreen.name -> ProfileScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognised")
        }
    }
}