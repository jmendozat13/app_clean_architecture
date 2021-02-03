package com.afoxplus.data.source.network

import com.afoxplus.data.source.IChatBotDataSource
import com.afoxplus.data.source.network.models.request.ChatBotRequest
import com.afoxplus.data.source.network.services.IChatBotService
import com.afoxplus.data.source.util.extension.onFailure
import com.afoxplus.data.source.util.extension.onSuccess
import com.afoxplus.domain.entities.ChatBot
import com.afoxplus.domain.exceptions.GenericException
import org.koin.core.inject

class ChatBotNetwork : IChatBotDataSource, BaseNetwork() {
    private val chatBotService: IChatBotService by inject()

    override suspend fun sendMessage(inputMessage: String): ChatBot {
        val response = chatBotService.sendMessage(ChatBotRequest(inputMessage = inputMessage))
        var chatBot: ChatBot? = null
        response.onSuccess { chatBotResponse -> chatBot = chatBotResponse.toChatBotEntity()  }
        response.onFailure { throw it.throwable }
        return chatBot ?: throw GenericException()
    }
}
