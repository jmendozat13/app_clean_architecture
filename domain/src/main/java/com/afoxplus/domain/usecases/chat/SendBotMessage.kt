package com.afoxplus.domain.usecases.chat

import com.afoxplus.domain.entities.chat.SendMessage
import com.afoxplus.domain.repository.account.IUserRepository
import com.afoxplus.domain.repository.chat.IChatBotRepository

interface SendBotMessage {
    suspend operator fun invoke(input: String)
}

class SendBotMessageImpl(
    private val chatBotRepository: IChatBotRepository,
    private val userRepository: IUserRepository
) : SendBotMessage {

    override suspend fun invoke(input: String) {
        val user = userRepository.getUser()
        val message = SendMessage(
            inputMessage = input,
            username = user?.name ?: "",
            userExternalId = (user?.id ?: 0).toString()
        )
        chatBotRepository.sendMessage(message)
    }
}