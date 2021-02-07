package com.afoxplus.appdemo.ui.chat


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.afoxplus.appdemo.ui.BaseViewModel
import com.afoxplus.domain.entities.Message
import com.afoxplus.domain.usecases.ChatBotUseCase
import kotlinx.coroutines.launch
import org.koin.core.inject

class ChatBotViewModel : BaseViewModel() {
    private val chatBotUseCase: ChatBotUseCase by inject()
    val allMessages: LiveData<List<Message>> = chatBotUseCase.allMessages.asLiveData()

    init {
        viewModelScope.launch {
            try {
                chatBotUseCase.sendMessage("Hola")
            } catch (ex: Throwable) {
                Log.d("Error", "${ex.message}")
            }

        }
    }
}