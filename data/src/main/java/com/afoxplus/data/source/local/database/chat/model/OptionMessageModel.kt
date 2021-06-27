package com.afoxplus.data.source.local.database.chat.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.afoxplus.domain.entities.chat.OptionMessage

@Entity(
    tableName = "options_messages",
    foreignKeys = [ForeignKey(
        entity = MessageModel::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("messageId"),
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.NO_ACTION
    )
    ]
)
data class OptionMessageModel(
    val title: String,
    val query: String,
    @ColumnInfo(index = true)
    val messageId: Long,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
) {
    fun toMessageOption(): OptionMessage = OptionMessage(
        title = title,
        id = id,
        query = query
    )

    companion object {
        private fun toOptionMessageModel(messageId: Long, optionMessage: OptionMessage) =
            OptionMessageModel(
                title = optionMessage.title,
                query = optionMessage.query,
                messageId = messageId
            )

        fun mapListToOptionMessageModel(messageId: Long, options: List<OptionMessage>) =
            options.map { item -> toOptionMessageModel(messageId, item) }

        fun toOptionMessageList(options: List<OptionMessageModel>?) =
            options?.map { item -> item.toMessageOption() }
    }
}