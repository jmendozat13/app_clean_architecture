package com.afoxplus.domain.repository

import com.afoxplus.domain.entities.Message
import kotlinx.coroutines.flow.Flow

interface IChatBotRepository : BaseRepository {
    val allMessages: Flow<List<Message>>
    suspend fun sendMessage(inputMessage: String)
}