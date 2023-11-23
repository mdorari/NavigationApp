package com.example.navigationapp.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.navigationapp.model.Movie
import com.example.navigationapp.model.getMovies
import com.example.navigationapp.widget.MovieDetailWidget

@Composable
fun DetailsScreen(navController: NavController, movieId: String?) {

    val newMovieList = getMovies().filter { movie ->
        movie.id == movieId
    }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (movieId != null) {
            MovieDetailWidget(movieData = newMovieList.first())
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Movie images")
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalScrollableImageView(newMovieList)
        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Back")
        }


    }
}

@Composable
private fun HorizontalScrollableImageView(newMovieList: List<Movie>) {
    LazyRow {
        items(newMovieList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(width = 200.dp, height = 120.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(image),
                    contentScale = ContentScale.Crop
//                            painter = rememberAsyncImagePainter(
//                                model = ImageRequest.Builder(LocalContext.current)
//                                    .data(image)
//                                    .scale(coil.size.Scale.FILL)
//                                    .size(coil.size.Size(200, 200))
//                                    .build()
//                            )

                    , contentDescription = "movie poster"
                )
            }

        }
    }
}