package com.afoxplus.data.source.network.chat

import com.afoxplus.data.source.network.core.BaseNetwork
import com.afoxplus.data.source.network.chat.request.ChatBotRequest
import com.afoxplus.data.source.network.chat.service.IChatBotService
import com.afoxplus.data.source.network.core.extension.onFailure
import com.afoxplus.data.source.network.core.extension.onSuccess
import com.afoxplus.domain.entities.chat.ChatBot
import com.afoxplus.domain.exceptions.GenericException
import org.koin.core.inject

class ChatBotNetworkDataSource : IChatBotNetworkDataSource, BaseNetwork() {
    private val chatBotService: IChatBotService by inject()

    override suspend fun sendMessage(inputMessage: String): ChatBot {
        val response = chatBotService.sendMessage(ChatBotRequest(inputMessage = inputMessage))
        var chatBot: ChatBot? = null
        response.onSuccess { chatBotResponse -> chatBot = chatBotResponse.toChatBotEntity() }
        response.onFailure { error -> throw error }
        return chatBot ?: throw GenericException()
    }
}
