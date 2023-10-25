package com.example.navigationapp.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigationapp.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), contentAlignment = Alignment.TopCenter
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(navController: NavController) {
    val myDummyData = "Lorem Impsum lorem details of my dummy data"
    Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Main Screen")
        Spacer(modifier = Modifier.height(200.dp))
        Button(onClick = { navController.navigate(route = Screens.DetailsScreen.name+"/$myDummyData")}) {
            Text(text = "Details Page")
        }
    }
}