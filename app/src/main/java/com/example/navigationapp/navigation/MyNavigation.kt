package com.example.navigationapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationapp.screens.ProfileScreen
import com.example.navigationapp.screens.details.DetailsScreen
import com.example.navigationapp.screens.home.HomeScreen

@Composable
fun MyNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.HomeScreen.name) {
        composable(Screens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(
            Screens.DetailsScreen.name + "/{data}",
            arguments = listOf(navArgument(name = "data") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailsScreen(
                navController = navController,
                detailsData = backStackEntry.arguments?.getString("data")
            )
        }
        composable(
            Screens.ProfileScreen.name + "/{data}",
            arguments = listOf(navArgument(name = "data") { type = NavType.StringType })
        ) { navBackStackEntry ->
            ProfileScreen(
                navController = navController,
                userName = navBackStackEntry.arguments?.getString("data")
            )
        }
    }
}