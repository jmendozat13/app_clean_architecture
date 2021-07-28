package com.afoxplus.data.source.local.database.chat

import com.afoxplus.domain.entities.chat.Message
import com.afoxplus.domain.entities.chat.OptionMessage
import kotlinx.coroutines.flow.Flow

interface IMessageLocalDataSource {
    suspend fun saveMessage(message: Message): Long
    suspend fun saveMessages(list: List<Message>)
    suspend fun deleteLoadingMessage()
    suspend fun showLoadingMessage()
    val allMessages: Flow<List<Message>>
    suspend fun saveMessageOptions(messageId: Long, options: List<OptionMessage>)
}