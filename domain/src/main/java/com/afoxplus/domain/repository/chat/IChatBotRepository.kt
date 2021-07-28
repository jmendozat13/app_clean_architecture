package com.afoxplus.domain.repository.chat

import com.afoxplus.domain.entities.chat.Message
import kotlinx.coroutines.flow.Flow

interface IChatBotRepository {
    val allMessages: Flow<List<Message>>
    suspend fun sendMessage(inputMessage: String)
}