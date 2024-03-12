package com.example.ws_preparation.presentation.ChatRider

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_preparation.domain.model.MessageData
import com.example.ws_preparation.domain.model.ProfileData
import com.example.ws_preparation.domain.repository.CreateChatRepository
import com.example.ws_preparation.domain.repository.CreateMessageRepository
import com.example.ws_preparation.domain.repository.GetChatIdRepository
import com.example.ws_preparation.domain.repository.GetMessageHistoryRepository
import com.example.ws_preparation.domain.repository.GetProfileRepository
import com.example.ws_preparation.domain.repository.GetProfileRoleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class ChatRiderViewModel @Inject constructor(
    private val getProfileRepository: GetProfileRepository,
    private val getProfileRoleRepository: GetProfileRoleRepository,
    private val getChatIdRepository: GetChatIdRepository,
    private val createChatRepository: CreateChatRepository,
    private val createMessageRepository: CreateMessageRepository,
    private val getMessageHistoryRepository: GetMessageHistoryRepository,
): ViewModel() {

    var profile by mutableStateOf(ProfileData())
        private set

    var message by mutableStateOf("")
        private set

    val messagesHistory = mutableStateListOf<MessageData>()

    var chatIsCreated = false

    var recipient_id = ""
    private var chat_id = ""

    fun setData(id: String){
        recipient_id = id
        getRecipientProfile(id)
    }

    private fun getRecipientProfile(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val profile = getProfileRepository.getProfile(id)
                withContext(Dispatchers.Main){
                    this@ChatRiderViewModel.profile = profile
                }
                val role = getProfileRoleRepository.getRole()
                getChatId(profile.user_id, role)
            }catch (e: Exception){
                Log.i("supabaseClient", e.message.toString())
            }
        }
    }
    
    private fun getChatId(id: String, role: String){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                chat_id = getChatIdRepository.get(id, role)
                getHistoryMessages()
            }catch (e: Exception){
                val message = e.message.toString()
                if (message.contains("\n")){
                    val messageException = message.substring(0, message.indexOf("\n"))
                    if (messageException.equals("JSON object requested, multiple (or no) rows returned (The result contains 0 rows)")){
                        if (!chatIsCreated){
                            chatIsCreated = true
                           createChat(id, role)
                       }
                    }
                }
                Log.i("supabaseClient", e.message.toString())
            }
        }
    }

    private fun createChat(id: String, role: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                createChatRepository.create(id, role)
                getChatId(id, role)
            }catch (e: Exception){
                Log.i("supabaseClient", e.message.toString())
            }
        }
    }

    private fun getHistoryMessages() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val history = getMessageHistoryRepository.get(chat_id)
                withContext(Dispatchers.Main){
                    if (messagesHistory.isEmpty()){
                        messagesHistory.addAll(history)
                    }
                }
                Log.i("supabaseClient", history.size.toString())
            }catch (e: Exception){
                Log.i("supabaseClient", e.message.toString())
            }
        }
    }

    fun redactMessage(txt: String){
        message = txt
    }

    fun postMessage(){
        val messageData = message
        message = ""
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (messageData.isNotEmpty()){
                    createMessageRepository.postMessage(
                        messageData,
                        chat_id,
                        recipient_id)
                }
            }catch (e: Exception){
                Log.i("supabaseClient", e.message.toString())
            }
        }
    }
}