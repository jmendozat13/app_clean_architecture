package com.afoxplus.domain.entities

import java.util.*

data class Message(
    val type: TypeMessage,
    val content: String,
    val dateTime: Date,
    val id: Int = 0,
)