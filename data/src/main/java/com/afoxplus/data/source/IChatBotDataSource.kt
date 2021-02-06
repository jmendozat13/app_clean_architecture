package com.afoxplus.data.source

import com.afoxplus.domain.entities.ChatBot

interface IChatBotDataSource : BaseDataSource {
    suspend fun sendMessage(inputMessage: String): ChatBot
}