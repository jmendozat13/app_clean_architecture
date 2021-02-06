package com.afoxplus.data.source.local.database

import com.afoxplus.data.source.IMessageDataSource
import com.afoxplus.data.source.local.database.dao.MessageDao
import com.afoxplus.data.source.local.database.model.MessageModel
import com.afoxplus.domain.entities.Message
import com.afoxplus.domain.entities.TypeMessage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.inject

class MessageDataBase : IMessageDataSource {

    private val messageDao: MessageDao by inject()

    override suspend fun saveMessage(message: Message) {
        messageDao.insert(MessageModel.toMessageModel(message))
    }

    override suspend fun deleteLoadMessage() {
        messageDao.deleteMessage(type = TypeMessage.LOADING.name)
    }

    override val allMessages: Flow<List<Message>>
        get() = messageDao.historyMessages().map { items -> MessageModel.toMessageList(items) }


}