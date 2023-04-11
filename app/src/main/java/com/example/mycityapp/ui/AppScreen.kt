package com.example.mycityapp.ui


//import androidx.lifecycle.viewmodel.compose.viewModel

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycityapp.R
import com.example.mycityapp.model.AppUiState
import com.example.mycityapp.model.AppViewModel
import com.example.mycityapp.model.Place
import com.example.mycityapp.model.parks


enum class Screens(@StringRes val title:Int) {
    HOME(R.string.scr_home),
   PLACES(R.string.scr_places),
    DETAILS(R.string.scr_details),
    EXPANDED(R.string.scr_expanded),
    EXPANDED_HOME(R.string.scr_home)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen(
    windowSize:WindowSizeClass,
    modifier: Modifier=Modifier
){

    val viewModel:AppViewModel =viewModel()
    val uiState:AppUiState by viewModel.uiState.collectAsState()
    val windowWidthSizeClass=windowSize.widthSizeClass
    val currentScreen=uiState.currentScreen
    val activity= LocalContext.current as Activity

    BackHandler {

        if (currentScreen==Screens.HOME|| currentScreen==Screens.EXPANDED_HOME){
            activity.finish()
        }
        else{
            viewModel.popBackScreen()
        }
    }

    Scaffold(
        topBar = { AppBar(currentScreen = currentScreen,
                          onBackClicked = {
                              if (currentScreen==Screens.HOME || currentScreen==Screens.EXPANDED_HOME) activity.finish()
                              else viewModel.popBackScreen()})
        }
    ) {paddingValues ->
        if (windowWidthSizeClass== WindowWidthSizeClass.Expanded && currentScreen!=Screens.EXPANDED && currentScreen!=Screens.EXPANDED_HOME){
            viewModel.toExpandedScreen()
        }
        if (windowWidthSizeClass!=WindowWidthSizeClass.Expanded && (currentScreen==Screens.EXPANDED )){
            viewModel.returnFromExpanded()
        }
            when (currentScreen) {
                Screens.HOME, Screens.EXPANDED_HOME -> {
                    PlaceList(
                        places = viewModel.getCategories(),
                        modifier = Modifier.padding(paddingValues)
                    ) { place: Place ->
                        viewModel.selectCategory(place)

                    }
                }
                Screens.PLACES -> {
                    PlaceList(
                        places = viewModel.getPlaces(),
                        modifier = Modifier.padding(paddingValues)
                    ) { place: Place ->
                        viewModel.selectItem(place)

                    }
                }
                Screens.DETAILS -> {
                    if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
                        RecommendedPlace(
                            uiState.selectedItem ?: parks[0],
                            modifier = Modifier.padding(paddingValues)
                        )
                    } else {
                        RecommendedPlaceLandscape(
                            place = uiState.selectedItem ?: parks[0],
                            modifier = Modifier.padding(paddingValues)
                        )
                    }
                }
                Screens.EXPANDED -> {
                    Row(modifier = Modifier.padding(paddingValues)) {
                        PlaceList(
                            places = viewModel.getPlaces(),
                            modifier = Modifier.weight(1f)
                        ) { place: Place ->
                            viewModel.selectItem(place)

                        }
                        RecommendedPlace(
                            place = uiState.selectedItem ?: parks[0],
                            modifier = Modifier.weight(1f)
                        )


                    }
                }
            }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    currentScreen:Screens,
    onBackClicked:()->Unit
){

    SmallTopAppBar(
        title = {Text(stringResource(id =currentScreen.title))},
        navigationIcon = {
        //    if (currentScreen!=Screens.HOME && currentScreen!=Screens.EXPANDED_HOME) {
                IconButton(onClick = onBackClicked) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back)
                    )
                }
          //  }
        }
    )
}