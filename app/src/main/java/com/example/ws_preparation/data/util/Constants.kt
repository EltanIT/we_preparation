package com.example.ws_preparation.data.util

import androidx.datastore.preferences.core.stringPreferencesKey

object Constants {

    val QUEUE = "QUEUE"


    object PreferencesKeys{
        val QUEUE =  stringPreferencesKey(Constants.QUEUE)
    }


    val emailValidPattern = "^[a-zA-Z0-9]+([@]{1})[a-zA-Z0-9]+([.]{1})+[a-z]"
}