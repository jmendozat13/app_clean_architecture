package com.afoxplus.appdemo.ui.chat

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.afoxplus.appdemo.R
import com.afoxplus.appdemo.core.Event
import com.afoxplus.appdemo.core.validators.LiveDataValidator
import com.afoxplus.appdemo.core.validators.LiveDataValidatorResolver
import com.afoxplus.appdemo.ui.BaseViewModel
import com.afoxplus.domain.entities.account.User
import com.afoxplus.domain.entities.chat.Message
import com.afoxplus.domain.entities.chat.OptionMessage
import com.afoxplus.domain.usecases.chat.ChatBotUseCase
import kotlinx.coroutines.launch
import org.koin.core.inject

class ChatBotViewModel : BaseViewModel() {
    private val chatBotUseCase: ChatBotUseCase by inject()
    private val context: Context by inject()

    var user: User = User.getUserDemo()
    val allMessages: LiveData<List<Message>> = chatBotUseCase.allMessages.asLiveData()

    val isButtonSendEnabled = MediatorLiveData<Boolean>()
    val chatInputTextField = MutableLiveData<String>()
    private val inputTexValidator = LiveDataValidator(chatInputTextField).apply {
        addRule("") { it.isNullOrBlank() }
    }

    val isUserChatFormValid = MediatorLiveData<Boolean>()
    val userNameField = MutableLiveData<String>()
    val userNameValidator = LiveDataValidator(userNameField).apply {
        addRule(context.getString(R.string.fragment_user_chat_validate)) { it.isNullOrBlank() }
    }

    private val mEventOnContinue: MutableLiveData<Event<String>> by lazy { MutableLiveData<Event<String>>() }
    val eventOnContinue: LiveData<Event<String>> get() = mEventOnContinue


    init {
        isUserChatFormValid.value = false
        isButtonSendEnabled.value = false
        isUserChatFormValid.addSource(userNameField) { validateFormUserChat() }
        isButtonSendEnabled.addSource(chatInputTextField) { validateButtonSend() }

    }

    fun onClickSendMessage() {
        viewModelScope.launch {
            try {
                val message = chatInputTextField.value ?: ""
                chatInputTextField.postValue("")
                chatBotUseCase.sendMessage(message)
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

    fun onClickContinue() = viewModelScope.launch {
        mEventOnContinue.postValue(Event(userNameField.value ?: ""))
    }

    private fun validateFormUserChat() {
        val validatorResolver = LiveDataValidatorResolver(listOf(userNameValidator))
        isUserChatFormValid.value = validatorResolver.isValid()
    }

    private fun validateButtonSend() {
        val validatorResolver = LiveDataValidatorResolver(listOf(inputTexValidator))
        isButtonSendEnabled.value = validatorResolver.isValid()
    }
}