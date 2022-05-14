package com.afoxplus.domain.usecases.chat

import kotlinx.coroutines.flow.collect

interface VerifyInitialMessage {
    suspend operator fun invoke()
}

internal class VerifyInitialMessageImpl(private val chatBotUseCase: ChatBotUseCase) :
    VerifyInitialMessage {
    override suspend fun invoke() {
        chatBotUseCase.allMessages.collect { msgs ->
            if (msgs.isEmpty())
                chatBotUseCase.getInitialGreetings()
        }
    }


}