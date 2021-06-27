package com.afoxplus.data.source.local.database.chat

import com.afoxplus.data.source.local.core.LocalBaseDataSource
import com.afoxplus.domain.entities.chat.Message
import kotlinx.coroutines.flow.Flow

interface IMessageLocalDataSource : LocalBaseDataSource {
    suspend fun saveMessage(message: Message)
    suspend fun deleteLoadMessage()
    suspend fun saveMessageLoad()
    val allMessages: Flow<List<Message>>
}