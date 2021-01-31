package com.afoxplus.domain.usecases

import com.afoxplus.domain.entities.ChatBot
import com.afoxplus.domain.repository.IChatBotRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.koin.core.inject

class ChatBotUseCase : BaseUseCase() {

    private val chatBotRepository: IChatBotRepository by inject()
    private val dispatcher: CoroutineDispatcher by inject()

    suspend fun sendMessage(inputMessage: String): ChatBot = withContext(dispatcher) {
        chatBotRepository.sendMessage(inputMessage)
    }
}