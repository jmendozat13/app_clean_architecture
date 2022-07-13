package com.afoxplus.domain.usecases.chat

import com.afoxplus.domain.entities.chat.SendMessage
import com.afoxplus.domain.repository.account.IUserRepository
import com.afoxplus.domain.repository.chat.IChatBotRepository
import kotlinx.coroutines.flow.collect

interface VerifyInitialMessage {
    suspend operator fun invoke()
}

internal class VerifyInitialMessageImpl(
    private val chatBotRepository: IChatBotRepository,
    private val userRepository: IUserRepository
) :
    VerifyInitialMessage {
    override suspend fun invoke() {
        chatBotRepository.allMessages.collect { msgs ->
            if (msgs.isEmpty()) {
                val user = userRepository.getUser()
                chatBotRepository.getInitialGreetings(
                    SendMessage(
                        inputMessage = MSG_HELLO,
                        username = user?.name ?: "",
                        userExternalId = user?.userExternalId.toString()
                    )
                )
            }
        }
    }

    companion object {
        private const val MSG_HELLO = "Saludo inicial"
    }
}