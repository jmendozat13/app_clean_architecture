package com.afoxplus.data.source

import com.afoxplus.domain.entities.Message
import kotlinx.coroutines.flow.Flow

interface IMessageDataSource : BaseDataSource {
    suspend fun saveMessage(message: Message)
    suspend fun deleteLoadMessage()
    val allMessages: Flow<List<Message>>
}