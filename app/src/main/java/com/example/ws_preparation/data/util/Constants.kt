package com.example.ws_preparation.data.util

import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

object Constants {

    val QUEUE = "QUEUE"


    object PreferencesKeys{
        val QUEUE =  stringPreferencesKey(Constants.QUEUE)
    }


    val emailValidPattern = "^[a-z0-9]+([@]{1})[a-z0-9]+([.]{1})+[a-z]+$"
}