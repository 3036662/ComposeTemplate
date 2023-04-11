package com.example.mycityapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycityapp.R
import com.example.mycityapp.model.Place
import com.example.mycityapp.model.restaurants
import com.example.mycityapp.ui.theme.MyCityAppTheme

@Composable
fun RecommendedPlace(
    place:Place,
    modifier: Modifier=Modifier
){
     Surface(modifier=modifier.fillMaxSize()) {
         Column(
             modifier = Modifier.shadow(5.dp).padding(20.dp)

         ) {
             Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                 Image(
                     painter = painterResource(id = R.drawable.baseline_image_24),
                     contentDescription = "Image for ${place.title}",
                     modifier = Modifier.sizeIn(80.dp, 80.dp, 160.dp, 160.dp),
                     alignment = Alignment.Center,
                     contentScale = ContentScale.FillWidth
                 )
             }
             Spacer(modifier = Modifier.height(10.dp))
             Text(text = stringResource(id = place.desc),modifier=Modifier.verticalScroll(rememberScrollState()))
         }
     }


}
@Composable
fun RecommendedPlaceLandscape(
    place: Place,
    modifier: Modifier=Modifier
){
    Surface(modifier=modifier.padding(10.dp).fillMaxSize()) {
        Row(
            modifier = modifier.shadow(5.dp).padding(20.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_image_24),
                contentDescription = "Image for ${place.title}",
                modifier = modifier.weight(0.5f),
                alignment = Alignment.Center,
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = modifier.height(10.dp))
            Text(text = stringResource(id = place.desc),modifier=modifier.weight(2.0f).verticalScroll(rememberScrollState()))
        }
    }
}


@Preview
@Composable
fun RecommendedPlacePreview(
){
    MyCityAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            RecommendedPlace(
                place = restaurants[0]
            )
        }
    }
}