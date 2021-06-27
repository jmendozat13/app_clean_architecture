package com.afoxplus.data.source.local.database.chat.model

import androidx.room.Embedded
import androidx.room.Relation
import com.afoxplus.domain.entities.chat.Message

data class MessageWithOptionsModel(
    @Embedded
    val message: MessageModel,
    @Relation(
        parentColumn = "id",
        entity = OptionMessageModel::class,
        entityColumn = "messageId"
    )
    val optionMessages: List<OptionMessageModel>?
) {

    fun mapMessage(): Message {
        val msg = message.toMessage()
        msg.options = OptionMessageModel.toOptionMessageList(optionMessages) ?: emptyList()
        return msg
    }
}