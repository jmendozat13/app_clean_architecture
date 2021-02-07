package com.afoxplus.data.repository

import com.afoxplus.data.source.IChatBotDataSource
import com.afoxplus.data.source.IMessageDataSource
import com.afoxplus.domain.entities.Message
import com.afoxplus.domain.entities.TypeMessage
import com.afoxplus.domain.repository.IChatBotRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.inject
import java.util.*

class ChatBotRepository : IChatBotRepository {

    private val chatBotDataSource: IChatBotDataSource by inject()
    private val messageDataSource: IMessageDataSource by inject()

    override val allMessages: Flow<List<Message>>
        get() = messageDataSource.allMessages

    override suspend fun sendMessage(inputMessage: String) {
        try {
            val startDate: Calendar = Calendar.getInstance()
            messageDataSource.deleteLoadMessage()
            messageDataSource.saveMessage(
                Message(
                    type = TypeMessage.REQUEST,
                    content = inputMessage,
                    dateTime = startDate.time
                )
            )
            messageDataSource.saveMessageLoad()
            val chatBot = chatBotDataSource.sendMessage(inputMessage)
            messageDataSource.deleteLoadMessage()
            messageDataSource.saveMessage(
                Message(
                    type = TypeMessage.RESPONSE,
                    content = chatBot.messageResponse,
                    dateTime = startDate.time
                )
            )
        } catch (ex: Throwable) {
            messageDataSource.deleteLoadMessage()
            throw ex
        }
    }

}