package com.example.navigationapp.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigationapp.model.Movie

@Composable
fun DetailsScreen(navController: NavController, detailsData: String?) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (detailsData != null) {
            Text(text = detailsData)
        }
        Spacer(modifier = Modifier.height(200.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Back")
        }


    }
}