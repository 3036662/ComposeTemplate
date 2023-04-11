package com.example.mycityapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycityapp.model.Place
import com.example.mycityapp.model.coffeeShops
import com.example.mycityapp.ui.theme.MyCityAppTheme

@Composable
fun PlaceList(
    places:List<Place>,
    modifier: Modifier=Modifier,
    onClickItem: (Place)->Unit
){
    LazyColumn(modifier = modifier){
        items(places){item: Place -> ListItem(place = item, modifier =Modifier,onClickItem)}
    }

}

@Composable
fun ListItem(
    place:Place,
    modifier: Modifier=Modifier,
    onClickItem: (Place) -> Unit
){
    Row(
        modifier.fillMaxWidth().clickable { onClickItem(place) },
        verticalAlignment = Alignment.CenterVertically
    ) {
       Image(painter = painterResource(id = place.img),
           contentDescription ="Image for ${place.title}",
           modifier = modifier.size(100.dp)
       )
        Spacer(modifier = modifier.size(20.dp))
        Text(
            stringResource(id = place.title),
            fontSize = 30.sp
        )
    }
}

@Preview
@Composable
fun ListItemPreview(){
    MyCityAppTheme() {
        Surface() {
            ListItem(place = coffeeShops[0]){place: Place -> {} }
        }
    }
}

@Preview
@Composable
fun PlaceListPreview(){
    MyCityAppTheme() {
        Surface(color =MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()) {
            PlaceList(places = coffeeShops){place:Place->{}}
        }
    }
}