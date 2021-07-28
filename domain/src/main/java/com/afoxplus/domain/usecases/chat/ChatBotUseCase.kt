package com.afoxplus.domain.usecases.chat

import com.afoxplus.domain.entities.chat.Message
import com.afoxplus.domain.repository.chat.IChatBotRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ChatBotUseCase @Inject constructor(private val chatBotRepository: IChatBotRepository) {

    val allMessages: Flow<List<Message>> = chatBotRepository.allMessages

    suspend fun sendMessage(inputMessage: String) = withContext(Dispatchers.IO) {
        chatBotRepository.sendMessage(inputMessage)
    }
}