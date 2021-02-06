package com.afoxplus.domain.usecases

import com.afoxplus.domain.repository.IChatBotRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.inject

class ChatBotUseCase : BaseUseCase() {

    private val chatBotRepository: IChatBotRepository by inject()

    suspend fun sendMessage(inputMessage: String) = withContext(Dispatchers.IO) {
        chatBotRepository.sendMessage(inputMessage)
    }
}