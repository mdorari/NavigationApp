package com.example.navigationapp.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigationapp.navigation.Screens


@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(10.dp), contentAlignment = Alignment.TopCenter
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(navController: NavController) {
    val myDummyData = "Lorem Imps um lorem details of my dummy data"
    val userName = "Mehrdad"
    Column(
        verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Main Screen")
        Row(modifier = Modifier.padding(40.dp).fillMaxWidth().clickable { navController.navigate(route = Screens.ProfileScreen.name + "/$userName") },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Profile picture")
            Text(text = userName)
        }
        Spacer(modifier = Modifier.height(200.dp))
        Button(onClick = { navController.navigate(route = Screens.DetailsScreen.name + "/$myDummyData") }) {
            Text(text = "Details Page")
        }
    }
}