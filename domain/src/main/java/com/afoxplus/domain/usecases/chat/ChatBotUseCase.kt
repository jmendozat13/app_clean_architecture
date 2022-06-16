package com.afoxplus.domain.usecases.chat

import com.afoxplus.domain.entities.chat.Message
import com.afoxplus.domain.repository.chat.IChatBotRepository
import com.afoxplus.domain.usecases.BaseUseCase
import kotlinx.coroutines.flow.Flow
import org.koin.core.inject

class ChatBotUseCase : BaseUseCase() {
    private val chatBotRepository: IChatBotRepository by inject()
    val allMessages: Flow<List<Message>> = chatBotRepository.allMessages
}