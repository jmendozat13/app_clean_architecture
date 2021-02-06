package com.afoxplus.domain.repository

interface IChatBotRepository : BaseRepository {
    suspend fun sendMessage(inputMessage: String)
}