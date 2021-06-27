package com.afoxplus.data.source.local.database.chat.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.afoxplus.domain.entities.chat.Message
import com.afoxplus.domain.entities.chat.TypeMessage
import java.util.*

@Entity(tableName = "messages")
data class MessageModel(
    val type: String,
    val content: String,
    val dateTime: Date,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
) {

    fun toMessage(): Message = Message(
        id = id,
        type = TypeMessage.valueOf(type),
        content = content,
        dateTime = dateTime
    )

    companion object {
        fun toMessageModel(message: Message) = MessageModel(
            type = message.type.name,
            content = message.content,
            dateTime = message.dateTime
        )

        fun toMessageList(messages: List<MessageWithOptionsModel>) =
            messages.map { item -> item.mapMessage() }
    }
}

