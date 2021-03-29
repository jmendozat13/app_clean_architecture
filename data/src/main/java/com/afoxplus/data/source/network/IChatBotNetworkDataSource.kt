package com.afoxplus.data.source.network

import com.afoxplus.data.source.BaseDataSource
import com.afoxplus.domain.entities.ChatBot

interface IChatBotNetworkDataSource : BaseDataSource {
    suspend fun sendMessage(inputMessage: String): ChatBot
}