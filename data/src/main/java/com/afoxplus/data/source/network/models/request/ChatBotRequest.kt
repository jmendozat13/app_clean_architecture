package com.afoxplus.data.source.network.models.request

import com.google.gson.annotations.SerializedName

data class ChatBotRequest(
    @SerializedName("input")
    val inputMessage: String
)