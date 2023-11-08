package com.example.navigationapp.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.navigationapp.model.Movie

@Composable
fun MovieRow(movieData: Movie, onItemClick: (String) -> Unit = {}) {
    var expanded by remember {
        mutableStateOf(false)
    }
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

                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text(text = "Hello there")
                    }
                }
            }
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = "Down Arrow",
                modifier = Modifier
                    .size(25.dp)
                    .clickable {
                        expanded = !expanded
                    },
                tint = Color.DarkGray
            )
        }
    }
}


@Composable
fun ExpandableCard(movieData: Movie, onItemClick: (String) -> Unit = {}) {
    var isExpanded by remember { mutableStateOf(false) }
//    val text by remember { mutableStateOf("This is the initial text.") }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { isExpanded = !isExpanded
                onItemClick(movieData.id)
            }
            .background(Color.White),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(4.dp)
//        backgroundColor = Color.White
    ) {
//        Column(
//            modifier = Modifier.fillMaxWidth()
//        ) {
            Row {
                // Left-hand side image
                Image(
                    painter = rememberAsyncImagePainter(movieData.images[0]),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Movie Poster"
                )
//                Image(
//                    painter = rememberAsyncImagePainter(
//                        ImageRequest.Builder(LocalContext.current)
//                            .data(data = "your_image_url_here").apply<ImageRequest.Builder>(block = fun ImageRequest.Builder.() {
//                                transformations(CircleCropTransformation())
//                            }).build()
//                    ),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .size(80.dp)
//                        .padding(16.dp)
//                        .clip(MaterialTheme.shapes.medium),
//                    contentScale = ContentScale.Crop
//                )

                // Right-hand side column with text and expand arrow
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = movieData.title, style = MaterialTheme.typography.labelLarge)
                    Text(text = movieData.year, style = MaterialTheme.typography.bodyMedium)
                    Text(text = movieData.genre, style = MaterialTheme.typography.bodyMedium)

                    // Arrow icon that changes direction
                    val arrowIcon = if (isExpanded) {
                        Icons.Default.KeyboardArrowUp
                    } else {
                        Icons.Default.KeyboardArrowDown
                    }

                    Icon(
                        imageVector = arrowIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .fillMaxWidth()
//                            .align(Alignment.CenterVertically)
                            .padding(16.dp)
                    )

                    if (isExpanded) {
                        // Expandable text field
                        Text(
                            text = movieData.plot,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .padding(16.dp)
                                .background(MaterialTheme.colorScheme.background)
                        )
                    }
                }


            }
//        }
    }
}

