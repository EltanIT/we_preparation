package com.example.ws_preparation.data.manger

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.ws_preparation.data.util.Constants
import com.example.ws_preparation.domain.manger.QueueManger
import kotlinx.coroutines.flow.first



// Класс для сохранения и извлечения очереди Onboard
// Мичкасов Георгий
// 28.02.2024 11.15
class QueueMangerImpl(
    val context: Context
): QueueManger {

    val Context.datastore: DataStore<Preferences> by preferencesDataStore(Constants.QUEUE)
    override suspend fun readQueue(): String? {
        return context.datastore.data.first()[Constants.PreferencesKeys.QUEUE]
    }

    override suspend fun saveQueue(queue: String) {
        context.datastore.edit {
            it[Constants.PreferencesKeys.QUEUE] = queue
        }
    }
}