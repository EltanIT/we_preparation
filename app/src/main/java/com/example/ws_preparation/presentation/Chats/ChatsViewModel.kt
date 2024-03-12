package com.example.ws_preparation.presentation.Chats

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_preparation.domain.repository.GetChatsProfileRepository
import com.example.ws_preparation.domain.repository.GetLastMessageRepository
import com.example.ws_preparation.domain.repository.GetProfileRoleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class ChatsViewModel @Inject constructor(
    private val getProfileRoleRepository: GetProfileRoleRepository,
    private val getChatsProfileRepository: GetChatsProfileRepository,
    private val getLastMessageRepository: GetLastMessageRepository,
): ViewModel() {


    val chatsList = mutableStateListOf<ChatsScreenData>()
    val fullChatsList = listOf<ChatsScreenData>()


    var exception by mutableStateOf("")
        private set

    var search by mutableStateOf("")
        private set


    fun redactSearch(txt: String){

    }


    init {
        getChats()
    }

    private fun getChats(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val role = getProfileRoleRepository.getRole()
                val chats = getChatsProfileRepository.getChats(role)
                withContext(Dispatchers.Main){
                    if (chatsList.isEmpty()){
                        for (i in chats){
                            chatsList.add(ChatsScreenData(user_id = i.user_id, name = i.fullName, image = i.image))
                            getLastMessage(role, i.user_id, chatsList.size-1)
                        }
                    }
                }

            }catch (e:Exception){
                withContext(Dispatchers.Main){
                    exception = e.message.toString()
                }
            }
        }
    }

    private fun getLastMessage(role: String, user_id: String, index: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val lastMessage = getLastMessageRepository.getLastMessage(role, user_id)
                withContext(Dispatchers.Main){
                    chatsList[index] = chatsList[index].copy(lastMessage = lastMessage)
                }
            }catch (e: Exception){
                Log.i("supabaseClient", e.message.toString())
                val message = e.message.toString()
                if (message.contains("\n")){
                    val messageException = message.substring(0, message.indexOf("\n"))
                    if (!messageException.equals("JSON object requested, multiple (or no) rows returned (The result contains 0 rows)")){
                        exception = message
                    }
                }else{
                    exception = message
                }

            }
        }
    }

    fun defaultException() {
        exception = ""
    }


}