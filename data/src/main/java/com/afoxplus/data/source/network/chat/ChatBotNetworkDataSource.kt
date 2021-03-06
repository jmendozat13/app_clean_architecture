package com.afoxplus.data.source.network.chat

import com.afoxplus.data.source.network.core.BaseNetwork
import com.afoxplus.data.source.network.chat.request.MessageRequest
import com.afoxplus.data.source.network.chat.service.IChatBotService
import com.afoxplus.data.source.network.core.extension.onFailure
import com.afoxplus.data.source.network.core.extension.onSuccess
import com.afoxplus.domain.entities.chat.Message
import com.afoxplus.domain.exceptions.GenericException
import org.koin.core.inject

class ChatBotNetworkDataSource : IChatBotNetworkDataSource, BaseNetwork() {
    private val chatBotService: IChatBotService by inject()

    override suspend fun sendMessage(inputMessage: String): Message {
        val response = chatBotService.sendMessage(MessageRequest(inputMessage = inputMessage))
        var chatBot: Message? = null
        response.onSuccess { chatBotResponse -> chatBot = chatBotResponse.toMessageEntity() }
        response.onFailure { error -> throw error }
        return chatBot ?: throw GenericException()
    }
}
