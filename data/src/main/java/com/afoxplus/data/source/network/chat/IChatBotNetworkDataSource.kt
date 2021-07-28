package com.afoxplus.data.source.network.chat

import com.afoxplus.domain.entities.chat.Message

interface IChatBotNetworkDataSource {
    suspend fun sendMessage(inputMessage: String): Message
}