package com.example.ws_preparation.presentation.Profile

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_preparation.R
import com.example.ws_preparation.domain.model.ProfileData
import com.example.ws_preparation.domain.repository.GetProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfileRepository: GetProfileRepository
): ViewModel() {


    val actionsList = listOf(
        ActionItem(
            "Edit Profile",
            "Name, phone no, address, email ...",
            R.drawable.ic_profile_unselected
        ),
        ActionItem(
            "Statements & Reports",
            "Download transaction details, orders, deliveries",
            R.drawable.ic_profile_unselected
        ),
        ActionItem(
            "Notification Settings",
            "mute, unmute, set location & tracking setting",
            R.drawable.ic_profile_unselected
        ),
        ActionItem(
            "Card & Bank account settings",
            "change cards, delete card details",
            R.drawable.ic_profile_unselected
        ),
        ActionItem(
            "Referrals",
            "check no of friends and earn",
            R.drawable.ic_profile_unselected
        ),
        ActionItem(
            "About Us",
            "know more about us, terms and conditions",
            R.drawable.ic_profile_unselected
        ),
        ActionItem(
            "Log Out",
            "",
            R.drawable.ic_profile_unselected
        ),
    )

    var profile by mutableStateOf(ProfileData())
        private set

    var isDarkMod by mutableStateOf(false)
        private set

    init {
        getProfile()
    }


    fun redactDarkMod(){
        isDarkMod = !isDarkMod
    }

    fun getProfile(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val profile = getProfileRepository.getProfile()
                withContext(Dispatchers.Main){
                    this@ProfileViewModel.profile = profile
                }
            }catch (e: Exception){
                Log.i("supabaseClient", e.message.toString())
            }
        }
    }



}