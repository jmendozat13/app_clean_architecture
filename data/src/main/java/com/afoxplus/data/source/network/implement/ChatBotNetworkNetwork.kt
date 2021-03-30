package com.afoxplus.data.source.network.implement

import com.afoxplus.data.source.network.IChatBotNetworkDataSource
import com.afoxplus.data.source.network.models.request.ChatBotRequest
import com.afoxplus.data.source.network.services.IChatBotService
import com.afoxplus.data.source.network.util.extension.onFailure
import com.afoxplus.data.source.network.util.extension.onSuccess
import com.afoxplus.domain.entities.ChatBot
import com.afoxplus.domain.exceptions.GenericException
import org.koin.core.inject

class ChatBotNetworkNetwork : IChatBotNetworkDataSource, BaseNetwork() {
    private val chatBotService: IChatBotService by inject()

    override suspend fun sendMessage(inputMessage: String): ChatBot {
        val response = chatBotService.sendMessage(ChatBotRequest(inputMessage = inputMessage))
        var chatBot: ChatBot? = null
        response.onSuccess { chatBotResponse -> chatBot = chatBotResponse.toChatBotEntity() }
        response.onFailure { error -> throw error }
        return chatBot ?: throw GenericException()
    }
}
