package com.afoxplus.data.source.network.chat.request

import com.google.gson.annotations.SerializedName

data class MessageRequest(
    @SerializedName("input")
    val inputMessage: String
)