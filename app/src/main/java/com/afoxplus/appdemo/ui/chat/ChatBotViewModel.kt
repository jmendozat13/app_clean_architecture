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
import com.afoxplus.domain.usecases.chat.SendBotMessage
import com.afoxplus.domain.usecases.chat.VerifyInitialMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.inject

class ChatBotViewModel : BaseViewModel() {
    private val chatBotUseCase: ChatBotUseCase by inject()
    private val sendBotMessage: SendBotMessage by inject()
    private val verifyInitialMessage: VerifyInitialMessage by inject()
    private val context: Context by inject()

    var user: User = User.getUserDemo()
    val allMessages: LiveData<List<Message>> = chatBotUseCase.allMessages.asLiveData()

    val chatInputTextField = MutableLiveData<String>()

    val isUserChatFormValid = MediatorLiveData<Boolean>()
    val userNameField = MutableLiveData<String>()
    val userNameValidator = LiveDataValidator(userNameField).apply {
        addRule(context.getString(R.string.fragment_user_chat_validate)) { it.isNullOrBlank() }
    }

    private val mEventOnContinue: MutableLiveData<Event<String>> by lazy { MutableLiveData<Event<String>>() }
    val eventOnContinue: LiveData<Event<String>> get() = mEventOnContinue


    init {
        isUserChatFormValid.value = false
        isUserChatFormValid.addSource(userNameField) { validateFormUserChat() }
    }

    fun onClickSendMessage() {
        viewModelScope.launch {
            try {
                val message = chatInputTextField.value ?: ""
                chatInputTextField.postValue("")
                sendBotMessage(message)
            } catch (ex: Throwable) {
                Log.d("Error", "${ex.message}")
            }
        }
    }

    fun onInitChatBot() = viewModelScope.launch(Dispatchers.IO) { verifyInitialMessage() }

    fun sendOption(option: OptionMessage) = viewModelScope.launch {
        try {
            sendBotMessage(option.query)
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
}