package com.afoxplus.data.source.network.chat

import com.afoxplus.data.source.network.chat.request.MessageRequest
import com.afoxplus.data.source.network.core.NetworkBaseDataSource
import com.afoxplus.domain.entities.chat.Message

interface IChatBotNetworkDataSource : NetworkBaseDataSource {
    suspend fun sendMessage(messageRequest: MessageRequest): Message
}