package com.example.mycityapp.model

import androidx.compose.ui.res.stringResource
import com.example.mycityapp.R

val restaurants= listOf<Place>(
    Place(R.string.rest_patriki, R.string.rest_patriki_desc),
    Place(R.string.rest_cidreria,R.string.rest_cidreria_desc),
    Place(R.string.rest_varvarka3,R.string.rest_varvarka3_desc),
    Place(R.string.rest_whiteRabbit,R.string.rest_whiteRabbit_desc),
    Place(R.string.rest_visota5642,R.string.rest_visota5642_desc)
)

val coffeeShops= listOf<Place>(
    Place(R.string.coffee_cvetnoy13,R.string.coffee_cvetnoy13_desc),
    Place(R.string.coffee_flat,R.string.coffee_flat_desc),
    Place(R.string.coffee_shelter,R.string.coffee_shelter_desc),
    Place(R.string.coffee_shortTalk,R.string.coffee_shortTalk_desc)
)

val forKids= listOf<Place>(
    Place(R.string.kids_arbat16,R.string.kids_arbat16_desc),
    Place(R.string.kids_kidburg,R.string.kids_kidburg_desc),
    Place(R.string.kids_kidzania,R.string.kids_kidzania_desc),
    Place(R.string.kids_ministry,R.string.kids_ministry_desc),
    Place(R.string.kids_unrealPlace,R.string.kids_unrealPlace_desc)
)

val parks= listOf<Place>(
    Place(R.string.park_caricino,R.string.park_caricino_desc),
    Place(R.string.park_gorky,R.string.park_gorky_descr),
    Place(R.string.park_izmailovo,R.string.park_izmailovo_desc),
    Place(R.string.park_kuskovo,R.string.park_kuskovo_desc)
)

// Categories
val categories= listOf<Place>(
    Place(R.string.cat_cofee),
    Place(R.string.cat_parks),
    Place(R.string.cat_rest),
    Place(R.string.cat_kidsFriendly)
)