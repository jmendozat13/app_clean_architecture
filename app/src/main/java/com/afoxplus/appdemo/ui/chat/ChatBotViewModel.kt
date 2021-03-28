package com.afoxplus.appdemo.ui.chat

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.afoxplus.appdemo.ui.BaseViewModel
import com.afoxplus.domain.entities.Message
import com.afoxplus.domain.entities.OptionMessage
import com.afoxplus.domain.usecases.ChatBotUseCase
import kotlinx.coroutines.launch
import org.koin.core.inject

class ChatBotViewModel : BaseViewModel() {
    private val chatBotUseCase: ChatBotUseCase by inject()
    val allMessages: LiveData<List<Message>> = chatBotUseCase.allMessages.asLiveData()
    var inputText = MutableLiveData<String>()

    fun onClickSendMessage() {
        viewModelScope.launch {
            try {
                chatBotUseCase.sendMessage(inputText.value ?: "")
            } catch (ex: Throwable) {
                Log.d("Error", "${ex.message}")
            }
        }
    }

    fun sendOption(option: OptionMessage) = viewModelScope.launch {
        try {
            chatBotUseCase.sendMessage(option.name)
        } catch (ex: Throwable) {
            Log.d("Error", "${ex.message}")
        }
    }
}