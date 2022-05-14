package com.afoxplus.domain.usecases.chat

import com.afoxplus.domain.entities.chat.Message
import com.afoxplus.domain.repository.chat.IChatBotRepository
import com.afoxplus.domain.usecases.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import org.koin.core.inject

class ChatBotUseCase(private val dispatcher: CoroutineDispatcher = Dispatchers.IO) : BaseUseCase() {

    private val chatBotRepository: IChatBotRepository by inject()

    val allMessages: Flow<List<Message>> = chatBotRepository.allMessages

    suspend fun sendMessage(inputMessage: String) = withContext(dispatcher) {
        chatBotRepository.sendMessage(inputMessage)
    }

    suspend fun getInitialGreetings() =
        withContext(dispatcher) { chatBotRepository.getInitialGreetings() }
}