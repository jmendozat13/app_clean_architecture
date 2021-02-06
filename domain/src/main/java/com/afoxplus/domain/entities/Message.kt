package com.afoxplus.domain.entities

import java.util.*

data class Message(
    val id: Int,
    val type: TypeMessage,
    val content: String,
    val dateTime: Date
)