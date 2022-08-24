package com.afoxplus.data.source.local.database.chat.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.afoxplus.domain.entities.chat.ImageMessage


@Entity(
    tableName = "images_messages",
    foreignKeys = [ForeignKey(
        entity = MessageModel::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("messageId"),
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.NO_ACTION
    )
    ]
)
data class ImageMessageModel(
    val image: String,
    @ColumnInfo(index = true)
    val messageId: Long,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
) {
    fun toMessageImage(): ImageMessage = ImageMessage(
        image = image,
        id = id
    )

    companion object {
        private fun toImageMessageModel(messageId: Long, imageMessage: ImageMessage) =
            ImageMessageModel(
                image = imageMessage.image,
                messageId = messageId
            )

        fun mapListToImageMessageModel(messageId: Long, images: List<ImageMessage>) =
            images.map { item -> toImageMessageModel(messageId, imageMessage = item) }

        fun toImageMessageList(images: List<ImageMessageModel>?) =
            images?.map { item -> item.toMessageImage() }
    }
}