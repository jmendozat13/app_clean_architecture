package com.afoxplus.domain.entities.chat

import com.afoxplus.domain.entities.account.User
import java.util.*

data class Message(
    val type: TypeMessage,
    var content: String,
    val dateTime: Date,
    val id: Long = 0,
    var options: List<OptionMessage> = emptyList()
){
    fun replaceUserName(user: User) {
        content = content.replace("NOMBRE", user.name)
    }
}

data class OptionMessage(val title: String, val query: String, val id: Long = 0)