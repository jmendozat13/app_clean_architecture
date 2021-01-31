package com.afoxplus.data.repository

import com.afoxplus.data.source.IChatBotDataSource
import com.afoxplus.domain.entities.ChatBot
import com.afoxplus.domain.repository.IChatBotRepository
import org.koin.core.inject

class ChatBotRepository : IChatBotRepository {

    private val chatBotDataSource: IChatBotDataSource by inject()

    override suspend fun sendMessage(inputMessage: String): ChatBot =
        chatBotDataSource.sendMessage(inputMessage)
}