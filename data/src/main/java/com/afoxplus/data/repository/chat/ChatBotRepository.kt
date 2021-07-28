package com.afoxplus.data.repository.chat

import com.afoxplus.data.source.network.chat.IChatBotNetworkDataSource
import com.afoxplus.data.source.local.database.chat.IMessageLocalDataSource
import com.afoxplus.domain.entities.chat.Message
import com.afoxplus.domain.entities.chat.TypeMessage
import com.afoxplus.domain.repository.chat.IChatBotRepository
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject

class ChatBotRepository @Inject constructor(
    private val chatBotNetworkDataSource: IChatBotNetworkDataSource,
    private val messageLocalDataSource: IMessageLocalDataSource
) : IChatBotRepository {

    override val allMessages: Flow<List<Message>>
        get() = messageLocalDataSource.allMessages

    override suspend fun sendMessage(inputMessage: String) {
        try {
            val startDate: Calendar = Calendar.getInstance()
            messageLocalDataSource.deleteLoadingMessage()
            messageLocalDataSource.saveMessage(
                Message(
                    type = TypeMessage.REQUEST,
                    content = inputMessage,
                    dateTime = startDate.time
                )
            )
            messageLocalDataSource.showLoadingMessage()
            val messageResponse = chatBotNetworkDataSource.sendMessage(inputMessage)
            val messageId = messageLocalDataSource.saveMessage(messageResponse)
            messageLocalDataSource.saveMessageOptions(messageId, messageResponse.options)
            messageLocalDataSource.deleteLoadingMessage()
        } catch (ex: Throwable) {
            messageLocalDataSource.deleteLoadingMessage()
            throw ex
        }
    }

}