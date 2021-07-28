package com.afoxplus.data.source.network.chat

import com.afoxplus.data.source.network.chat.request.MessageRequest
import com.afoxplus.data.source.network.chat.service.IChatBotService
import com.afoxplus.data.source.network.core.extension.map
import com.afoxplus.domain.entities.chat.Message
import com.afoxplus.domain.core.exceptions.GenericException
import javax.inject.Inject

class ChatBotNetworkDataSource @Inject constructor(private val chatBotService: IChatBotService) :
    IChatBotNetworkDataSource {

    override suspend fun sendMessage(inputMessage: String): Message {
        val response = chatBotService.sendMessage(MessageRequest(inputMessage = inputMessage))
        var chatBot: Message? = null
        response.map { messageResponse ->
            chatBot = messageResponse.toMessageEntity()
        }
        return chatBot ?: throw GenericException()
    }
}
