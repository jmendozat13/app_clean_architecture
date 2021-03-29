package com.afoxplus.data.source.local

import com.afoxplus.data.source.BaseDataSource
import com.afoxplus.domain.entities.Message
import kotlinx.coroutines.flow.Flow

interface IMessageLocalDataSource : BaseDataSource {
    suspend fun saveMessage(message: Message)
    suspend fun deleteLoadMessage()
    suspend fun saveMessageLoad()
    val allMessages: Flow<List<Message>>
}