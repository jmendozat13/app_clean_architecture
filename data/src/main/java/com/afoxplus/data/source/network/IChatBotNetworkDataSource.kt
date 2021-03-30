package com.afoxplus.data.source.network

import com.afoxplus.data.source.BaseDataSource
import com.afoxplus.domain.entities.chat.ChatBot

interface IChatBotNetworkDataSource : BaseDataSource {
    suspend fun sendMessage(inputMessage: String): ChatBot
}