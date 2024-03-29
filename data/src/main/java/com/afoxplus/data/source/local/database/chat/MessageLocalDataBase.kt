package com.afoxplus.data.source.local.database.chat

import com.afoxplus.data.source.local.database.chat.dao.ImageMessageDao
import com.afoxplus.data.source.local.database.chat.dao.MessageDao
import com.afoxplus.data.source.local.database.chat.dao.OptionMessageDao
import com.afoxplus.data.source.local.database.chat.model.ImageMessageModel
import com.afoxplus.data.source.local.database.chat.model.MessageModel
import com.afoxplus.data.source.local.database.chat.model.OptionMessageModel
import com.afoxplus.domain.entities.chat.ImageMessage
import com.afoxplus.domain.entities.chat.Message
import com.afoxplus.domain.entities.chat.OptionMessage
import com.afoxplus.domain.entities.chat.TypeMessage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.inject
import java.util.*

class MessageLocalDataBase : IMessageLocalDataSource {

    private val messageDao: MessageDao by inject()
    private val optionMessageDao: OptionMessageDao by inject()
    private val imageMessageDao: ImageMessageDao by inject()

    override suspend fun saveMessage(message: Message): Long =
        messageDao.insertOneMessage(MessageModel.toMessageModel(message))

    override suspend fun saveMessages(list: List<Message>) {
        val ms = list.map { item -> MessageModel.toMessageModel(item) }
        messageDao.insert(*ms.toTypedArray())
    }

    override suspend fun deleteLoadingMessage() {
        messageDao.deleteMessage(type = TypeMessage.LOADING.name)
    }

    override suspend fun showLoadingMessage() {
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
        get() = messageDao.readMessage().map { items -> MessageModel.toMessageList(items) }

    override suspend fun saveMessageOptions(messageId: Long, options: List<OptionMessage>) {
        val msOptions = OptionMessageModel.mapListToOptionMessageModel(messageId, options)
        optionMessageDao.insert(*msOptions.toTypedArray())
    }

    override suspend fun saveMessageImage(messageId: Long, images: List<ImageMessage>) {
        val msImages = ImageMessageModel.mapListToImageMessageModel(messageId, images = images)
        imageMessageDao.insert(*msImages.toTypedArray())
    }
}