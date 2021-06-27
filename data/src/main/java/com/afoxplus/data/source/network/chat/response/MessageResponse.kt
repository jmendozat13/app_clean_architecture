package com.afoxplus.data.source.network.chat.response

import com.afoxplus.domain.entities.chat.Message
import com.afoxplus.domain.entities.chat.OptionMessage
import com.afoxplus.domain.entities.chat.TypeMessage
import com.google.gson.annotations.SerializedName
import java.util.*

data class MessageResponse(
    @SerializedName("outputmessage") val message: String? = null,
    @SerializedName("options") val options: List<OptionMessageResponse>? = null
) {
    fun toMessageEntity(): Message = Message(
        type = TypeMessage.RESPONSE,
        content = message ?: "",
        dateTime = Calendar.getInstance().time,
        options = options?.map { item -> item.toOptionMessage() } ?: emptyList()
    )
}

data class OptionMessageResponse(
    @SerializedName("title") val title: String? = null,
    @SerializedName("query") val query: String? = null
) {
    fun toOptionMessage(): OptionMessage = OptionMessage(title = title ?: "", query = query ?: "")
}