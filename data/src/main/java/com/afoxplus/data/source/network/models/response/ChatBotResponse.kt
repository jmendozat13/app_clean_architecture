package com.afoxplus.data.source.network.models.response

import com.afoxplus.domain.entities.chat.ChatBot
import com.google.gson.annotations.SerializedName

data class ChatBotResponse(
    @SerializedName("outputmessage")
    val message: String? = null
) {
    fun toChatBotEntity(): ChatBot = ChatBot(messageResponse = message ?: "")
}