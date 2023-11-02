package com.example.navigationapp.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.navigationapp.model.Movie

@Composable
fun MovieRow(movieData: Movie, onItemClick: (String) -> Unit = {}) {
    Card(modifier = Modifier
        .padding(4.dp)
        .clickable { onItemClick(movieData.id) }) {
        Row {
            Surface(
                modifier = Modifier
                    .size(100.dp)
                    .padding(6.dp),
                shape = RoundedCornerShape(50.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(movieData.images[0]),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Movie Poster"
                )
            }
//            Icon(imageVector = Icons.Default.Face, contentDescription = "Movie picture")
            Column {
                Text(text = movieData.title)
                Text(text = movieData.rating)
                Text(text = movieData.plot)
            }
        }
    }
}
