package com.afoxplus.domain.repository.chat

import com.afoxplus.domain.entities.chat.Message
import com.afoxplus.domain.entities.chat.SendMessage
import com.afoxplus.domain.repository.BaseRepository
import kotlinx.coroutines.flow.Flow

interface IChatBotRepository : BaseRepository {
    val allMessages: Flow<List<Message>>
    suspend fun sendMessage(sendMessage: SendMessage)
    suspend fun getInitialGreetings(sendMessage: SendMessage)
}