package com.afoxplus.data.source.local.database.chat

import com.afoxplus.data.source.local.database.chat.dao.MessageDao
import com.afoxplus.data.source.local.database.chat.model.MessageModel
import com.afoxplus.domain.entities.chat.Message
import com.afoxplus.domain.entities.chat.TypeMessage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.inject
import java.util.*

class MessageLocalDataBase : IMessageLocalDataSource {

    private val messageDao: MessageDao by inject()

    override suspend fun saveMessage(message: Message) {
        messageDao.insert(MessageModel.toMessageModel(message))
    }

    override suspend fun deleteLoadMessage() {
        messageDao.deleteMessage(type = TypeMessage.LOADING.name)
    }

    override suspend fun saveMessageLoad() {
        val startDate: Calendar = Calendar.getInstance()
        messageDao.insert(
            MessageModel.toMessageModel(
                Message(
                    type = TypeMessage.LOADING,
                    content = "",
                    dateTime = startDate.time
                )
            )
        )
    }

    override val allMessages: Flow<List<Message>>
        get() = messageDao.historyMessages().map { items -> MessageModel.toMessageList(items) }


}