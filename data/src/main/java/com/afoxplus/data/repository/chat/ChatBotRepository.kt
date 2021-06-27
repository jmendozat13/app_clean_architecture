package com.afoxplus.data.repository.chat

import com.afoxplus.data.source.network.chat.IChatBotNetworkDataSource
import com.afoxplus.data.source.local.database.chat.IMessageLocalDataSource
import com.afoxplus.domain.entities.chat.Message
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

    override suspend fun sendMessage(inputMessage: String) {
        try {
            val startDate: Calendar = Calendar.getInstance()
            messageLocalDataSource.deleteLoadMessage()
            messageLocalDataSource.saveMessage(
                Message(
                    type = TypeMessage.REQUEST,
                    content = inputMessage,
                    dateTime = startDate.time
                )
            )
            messageLocalDataSource.saveMessageLoad()
            val chatBot = chatBotNetworkDataSource.sendMessage(inputMessage)
            messageLocalDataSource.deleteLoadMessage()
            messageLocalDataSource.saveMessage(
                Message(
                    type = TypeMessage.RESPONSE,
                    content = chatBot.messageResponse,
                    dateTime = startDate.time
                )
            )
        } catch (ex: Throwable) {
            messageLocalDataSource.deleteLoadMessage()
            throw ex
        }
    }

}