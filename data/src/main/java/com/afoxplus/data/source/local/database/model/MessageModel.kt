package com.afoxplus.data.source.local.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.afoxplus.domain.entities.Message
import com.afoxplus.domain.entities.TypeMessage
import java.util.*

@Entity
data class MessageModel(
    val type: String,
    val content: String,
    val dateTime: Date,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
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

        fun toMessageList(messages: List<MessageModel>) = messages.map { item -> item.toMessage() }
    }
}

