package com.afoxplus.data.source.network.services

import com.afoxplus.data.source.network.models.request.ChatBotRequest
import com.afoxplus.data.source.network.models.response.ChatBotResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface IChatBotService {
    @POST("kendalbot")
    suspend fun sendMessage(@Body chatBotRequest: ChatBotRequest): Response<ChatBotResponse>
}