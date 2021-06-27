package com.afoxplus.domain.entities.chat

import java.util.*

data class Message(
    val type: TypeMessage,
    val content: String,
    val dateTime: Date,
    val id: Long = 0,
    var options: List<OptionMessage> = emptyList()
)

data class OptionMessage(val title: String, val query: String, val id: Long = 0)