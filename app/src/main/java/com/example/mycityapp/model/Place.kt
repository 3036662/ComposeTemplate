package com.example.mycityapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.res.painterResource
import com.example.mycityapp.R

data class Place(
    @StringRes val title:Int,
    @StringRes val desc:Int=R.string.no_description,
    @StringRes val address:Int?=null,
    @DrawableRes val img:Int= R.drawable.baseline_image_24
)
