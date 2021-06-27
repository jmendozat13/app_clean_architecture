package com.afoxplus.data.source.network.chat.service

import com.afoxplus.data.source.network.chat.request.MessageRequest
import com.afoxplus.data.source.network.chat.response.MessageResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface IChatBotService {
    @POST("kendalbot")
    suspend fun sendMessage(@Body messageRequest: MessageRequest): Response<MessageResponse>
}