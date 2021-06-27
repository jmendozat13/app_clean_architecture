package com.afoxplus.data.source.network.chat.service

import com.afoxplus.data.source.network.chat.request.ChatBotRequest
import com.afoxplus.data.source.network.chat.response.ChatBotResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface IChatBotService {
    @POST("kendalbot")
    suspend fun sendMessage(@Body chatBotRequest: ChatBotRequest): Response<ChatBotResponse>
}