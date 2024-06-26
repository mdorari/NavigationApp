package com.example.navigationapp.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.navigationapp.model.getMovies
import com.example.navigationapp.navigation.Screens
import com.example.navigationapp.widget.ExpandableCard


@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 10.dp, start = 10.dp, end = 10.dp),
        contentAlignment = Alignment.TopCenter
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
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "Main Screen")
            Spacer(modifier = Modifier.size(30.dp))
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Profile picture")
            Text(modifier = Modifier.clickable { navController.navigate(route = Screens.ProfileScreen.name + "/$userName") },text = userName)
        }
//        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
//            .padding(top = 4.dp, start = 4.dp, end = 4.dp)
        ) {
            items(items = getMovies()) {
                ExpandableCard(movieData = it){movieData->
                    navController.navigate(route = Screens.DetailsScreen.name + "/$movieData")
                }
            }
        }

        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Home")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Brows")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "News")
            }
            Button(onClick = { navController.navigate(route = Screens.ProfileScreen.name + "/$userName")}) {
                Text(text = "Profile")
            }
        }
    }
}