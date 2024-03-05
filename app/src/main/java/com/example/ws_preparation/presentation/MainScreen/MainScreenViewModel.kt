package com.example.ws_preparation.presentation.MainScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ws_preparation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainScreenViewModel @Inject constructor(): ViewModel() {

    val navigationList = listOf(
        NavigationItem(
            "Home",
            R.drawable.ic_selected_home,
            R.drawable.ic_profile_unselected
        ),
        NavigationItem(
            "Wallet",
            R.drawable.ic_unselected_wallet,
            R.drawable.ic_unselected_wallet
        ),
        NavigationItem(
            "Track",
            R.drawable.ic_track_unselected,
            R.drawable.ic_track_unselected
        ),
        NavigationItem(
            "Profile",
            R.drawable.ic_profile_selected,
            R.drawable.ic_profile_unselected
        ),
    )

    var selectedIndex by mutableStateOf(0)
        private set


    fun redactSelectedIndex(index: Int) {
        selectedIndex = index
    }
}