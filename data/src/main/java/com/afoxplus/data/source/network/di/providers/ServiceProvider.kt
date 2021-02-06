package com.afoxplus.data.source.network.di.providers

import com.afoxplus.data.source.network.services.IChatBotService
import retrofit2.Retrofit

fun providerChatBotService(retrofit: Retrofit): IChatBotService =
    retrofit.create(IChatBotService::class.java)