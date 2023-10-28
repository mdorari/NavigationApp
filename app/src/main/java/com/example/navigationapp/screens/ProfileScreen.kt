package com.example.navigationapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController,userName:String?) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(4.dp)){
        Column {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Profile picture")
            if (userName != null) {
                Text(text = userName)
            }else{
                Text(text = "N/A")
            }
            Button(onClick = {navController.popBackStack()}) {
                Text(text = "Back")
            }
        }
    }
}