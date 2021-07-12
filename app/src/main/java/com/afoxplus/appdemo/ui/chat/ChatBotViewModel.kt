package com.afoxplus.appdemo.ui.chat

import android.util.Log
import androidx.lifecycle.*
import com.afoxplus.appdemo.core.Event
import com.afoxplus.appdemo.core.validators.LiveDataValidator
import com.afoxplus.appdemo.core.validators.LiveDataValidatorResolver
import com.afoxplus.appdemo.ui.BaseViewModel
import com.afoxplus.domain.entities.chat.Message
import com.afoxplus.domain.entities.chat.OptionMessage
import com.afoxplus.domain.usecases.chat.ChatBotUseCase
import kotlinx.coroutines.launch
import org.koin.core.inject

class ChatBotViewModel : BaseViewModel() {
    private val chatBotUseCase: ChatBotUseCase by inject()

    val allMessages: LiveData<List<Message>> = chatBotUseCase.allMessages.asLiveData()

    val chatInputTextField = MutableLiveData<String>()

    val isUserChatFormValid = MediatorLiveData<Boolean>()
    val userNameField = MutableLiveData<String>()
    val userNameValidator = LiveDataValidator(userNameField).apply {
        addRule("Username is required") { it.isNullOrBlank() }
    }


    private val mEventOnContinue: MutableLiveData<Event<Unit>> by lazy { MutableLiveData<Event<Unit>>() }
    val eventOnContinue: LiveData<Event<Unit>> get() = mEventOnContinue


    init {
        isUserChatFormValid.value = false
        isUserChatFormValid.addSource(userNameField) { validateFormUserChat() }
    }


    fun onClickSendMessage() {
        viewModelScope.launch {
            try {
                chatBotUseCase.sendMessage(chatInputTextField.value ?: "")
            } catch (ex: Throwable) {
                Log.d("Error", "${ex.message}")
            }
        }
    }

    fun sendOption(option: OptionMessage) = viewModelScope.launch {
        try {
            chatBotUseCase.sendMessage(option.query)
        } catch (ex: Throwable) {
            Log.d("Error", "${ex.message}")
        }
    }

    fun onClickContinue() {
        //Do save username
        mEventOnContinue.postValue(Event(Unit))
    }

    private fun validateFormUserChat() {
        val validatorResolver = LiveDataValidatorResolver(listOf(userNameValidator))
        isUserChatFormValid.value = validatorResolver.isValid()
    }
}