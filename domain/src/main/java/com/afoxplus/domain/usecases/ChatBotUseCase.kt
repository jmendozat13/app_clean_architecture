package com.afoxplus.domain.usecases

import com.afoxplus.domain.entities.Message
import com.afoxplus.domain.repository.IChatBotRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import org.koin.core.inject

class ChatBotUseCase : BaseUseCase() {

    private val chatBotRepository: IChatBotRepository by inject()

    val allMessages: Flow<List<Message>> = chatBotRepository.allMessages

    suspend fun sendMessage(inputMessage: String) = withContext(Dispatchers.IO) {
        chatBotRepository.sendMessage(inputMessage)
    }
}