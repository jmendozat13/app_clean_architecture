package com.afoxplus.domain.repository

import com.afoxplus.domain.entities.ChatBot

interface IChatBotRepository : BaseRepository {
    suspend fun sendMessage(inputMessage: String): ChatBot
}