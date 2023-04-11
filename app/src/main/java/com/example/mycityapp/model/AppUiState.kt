package com.example.mycityapp.model

import com.example.mycityapp.ui.Screens

data class AppUiState (
    val selectedItem:Place?=null,
    val selectedCategory:Place?=null,
    val currentScreen:Screens=Screens.HOME,
    val prevScreen:Screens=Screens.HOME,

)