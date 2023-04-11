package com.example.mycityapp.model


import android.util.Log
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import com.example.mycityapp.R
import com.example.mycityapp.ui.Screens
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel:ViewModel() {
    private val _uiState= MutableStateFlow(AppUiState())
    val uiState :StateFlow<AppUiState> =_uiState.asStateFlow()
    fun getCategories():List<Place>{
        return categories
    }

    fun getPlaces():List<Place>{
        Log.d("TEST", uiState.value.toString())
       return when(uiState.value.selectedCategory?.title ?: parks[0]){
            R.string.cat_rest-> restaurants
            R.string.cat_kidsFriendly-> forKids
            R.string.cat_parks-> parks
            R.string.cat_cofee-> coffeeShops
           else -> restaurants
        }
    }




    fun selectItem(place: Place){
        _uiState.update {
            val newscr=if (it.currentScreen!=Screens.EXPANDED) Screens.DETAILS else Screens.EXPANDED

            it.copy(selectedItem = place, currentScreen = newscr)
        }
    }

    fun selectCategory(place: Place){
        //Log.d("TEST","Selected category $place")
        _uiState.update {
            it.copy(selectedCategory = place, currentScreen = Screens.PLACES)
        }
    }

    fun toExpandedScreen(){
        _uiState.update {
            val currscr=it.currentScreen
            it.copy(currentScreen = Screens.EXPANDED, prevScreen = currscr) }
    }

    fun returnFromExpanded(){
        _uiState.update {
            val curscr=it.prevScreen
            it.copy(currentScreen =curscr)
        }
    }



    fun popBackScreen(){
        _uiState.update {
            val oldScreen=it.currentScreen
            val newscreen=when (oldScreen){
                Screens.DETAILS->Screens.PLACES
                Screens.PLACES->Screens.HOME
                Screens.HOME->Screens.HOME
                Screens.EXPANDED_HOME->Screens.EXPANDED_HOME
                Screens.EXPANDED->Screens.EXPANDED_HOME
            }
            it.copy(currentScreen = newscreen, prevScreen = oldScreen)
        }
    }

}
