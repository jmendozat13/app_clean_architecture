package com.afoxplus.data.repository.chat

import com.afoxplus.data.source.network.chat.IChatBotNetworkDataSource
import com.afoxplus.data.source.local.database.chat.IMessageLocalDataSource
import com.afoxplus.data.source.network.chat.request.MessageRequest
import com.afoxplus.domain.entities.chat.Message
import com.afoxplus.domain.entities.chat.SendMessage
import com.afoxplus.domain.entities.chat.TypeMessage
import com.afoxplus.domain.repository.chat.IChatBotRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.inject
import java.util.*

class ChatBotRepository : IChatBotRepository {

    private val chatBotNetworkDataSource: IChatBotNetworkDataSource by inject()
    private val messageLocalDataSource: IMessageLocalDataSource by inject()

    override val allMessages: Flow<List<Message>>
        get() = messageLocalDataSource.allMessages

    override suspend fun sendMessage(sendMessage: SendMessage) {
        try {
            val startDate: Calendar = Calendar.getInstance()
            messageLocalDataSource.deleteLoadingMessage()
            messageLocalDataSource.saveMessage(
                Message(
                    type = TypeMessage.REQUEST,
                    content = sendMessage.inputMessage,
                    dateTime = startDate.time
                )
            )
            messageLocalDataSource.showLoadingMessage()
            val messageResponse =
                chatBotNetworkDataSource.sendMessage(convertToMessageRequest(sendMessage))
            val messageId = messageLocalDataSource.saveMessage(messageResponse)
            messageLocalDataSource.saveMessageOptions(messageId, messageResponse.options)
            messageLocalDataSource.saveMessageImage(messageId, messageResponse.images)
            messageLocalDataSource.deleteLoadingMessage()
        } catch (ex: Throwable) {
            messageLocalDataSource.deleteLoadingMessage()
            throw ex
        }
    }

    override suspend fun getInitialGreetings(sendMessage: SendMessage) {
        try {
            messageLocalDataSource.showLoadingMessage()
            val messageResponse =
                chatBotNetworkDataSource.sendMessage(convertToMessageRequest(sendMessage))
            val messageId = messageLocalDataSource.saveMessage(messageResponse)
            messageLocalDataSource.saveMessageOptions(messageId, messageResponse.options)
            messageLocalDataSource.saveMessageImage(messageId, messageResponse.images)
            messageLocalDataSource.deleteLoadingMessage()
        } catch (ex: Throwable) {
            messageLocalDataSource.deleteLoadingMessage()
            throw ex
        }
    }

    private fun convertToMessageRequest(sendMessage: SendMessage) =
        MessageRequest(
            inputMessage = sendMessage.inputMessage,
            username = sendMessage.username,
            userExternalId = sendMessage.userExternalId
        )

}