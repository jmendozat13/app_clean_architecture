package com.afoxplus.data.source.network.chat

import com.afoxplus.data.source.network.core.NetworkBaseDataSource
import com.afoxplus.domain.entities.chat.Message

interface IChatBotNetworkDataSource : NetworkBaseDataSource {
    suspend fun sendMessage(inputMessage: String): Message
}